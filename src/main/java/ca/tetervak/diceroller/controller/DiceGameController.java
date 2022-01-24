package ca.tetervak.diceroller.controller;

import ca.tetervak.diceroller.domain.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DiceGameController {

    private final Logger logger = LoggerFactory.getLogger(DiceGameController.class);

    @GetMapping(value = {"/", "/dice-game"})
    public ModelAndView diceGame(
            @RequestParam(defaultValue = "3") int numberOfDice,
            @RequestParam(defaultValue = "false") boolean isRolled
    ) {
        logger.trace("diceGame() is called");

        Game game = new Game(numberOfDice);
        if (isRolled) {
            game.roll();
        }

        return new ModelAndView("DiceGame", "game", game);
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        logger.error("Request: " + req.getRequestURL() + " raised " + ex);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("Exception");
        return mav;
    }
}
