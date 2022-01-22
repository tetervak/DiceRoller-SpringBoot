package ca.tetervak.diceroller.domain;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void getNumberOfDice() {
        Game game = new Game();
        assertEquals(Game.DEFAULT_NUMBER_OF_DICE, game.getNumberOfDice());
    }

    @Test
    void setNumberOfDice_five() {
        int numberOfDice = 5;
        Game game = new Game(numberOfDice);
        assertEquals(game.getNumberOfDice(), numberOfDice);
    }

    @Test
    void isRolled() {
        Game game = new Game();
        assertFalse(game.isRolled());
        game.roll();
        assertTrue(game.isRolled());
    }

    @Test
    void getTotal() {
        int numberOfDice = 7;
        Game game = new Game(numberOfDice);
        assertFalse(game.isRolled());
        assertEquals(0, game.getTotal());
        game.roll();
        assertTrue(game.isRolled());
        assertTrue(game.getTotal() >= numberOfDice);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6})
    void getDice(int numberOfDice) {
        Game game = new Game(numberOfDice);
        assertEquals(numberOfDice, game.getDice().length);
    }

    @RepeatedTest(5)
    void roll() {
        int numberOfDice = 4;
        Game game = new Game(numberOfDice);
        assertFalse(game.isRolled());
        game.roll();
        assertTrue(game.isRolled());
        assertTrue(game.getTotal() >= numberOfDice);
    }

    @Test
    void reset() {
        int numberOfDice = 5;
        Game game = new Game(numberOfDice);
        game.roll();
        game.reset();
        assertFalse(game.isRolled());
        assertEquals(0, game.getTotal());
    }
}