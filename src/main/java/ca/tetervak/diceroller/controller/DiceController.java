package ca.tetervak.diceroller.controller;

import ca.tetervak.diceroller.domain.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DiceController {

    private final Logger logger = LoggerFactory.getLogger(DiceController.class);

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
}
