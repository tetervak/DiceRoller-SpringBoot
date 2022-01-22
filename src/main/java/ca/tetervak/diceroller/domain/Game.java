package ca.tetervak.diceroller.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Random;

public class Game implements Serializable {

    private final Logger logger = LoggerFactory.getLogger(Game.class);

    public static final int DEFAULT_NUMBER_OF_DICE = 3;

    private int numberOfDice;
    private Die[] dice;
    private boolean isRolled = false;

    final private Random random;

    public Game() {
        this(DEFAULT_NUMBER_OF_DICE);
    }

    public Game(int numberOfDice) {
        this(numberOfDice, new Random());
    }

    public Game(int numberOfDice, Random random) {
        logger.trace("Game constructor is called");
        this.random = random;
        setNumberOfDice(numberOfDice);
    }

    public int getNumberOfDice() {
        logger.trace("getNumberOfDice() is called");
        return numberOfDice;
    }

    public final void setNumberOfDice(int numberOfDice) {
        logger.trace("setNumberOfDice() is called");
        if(numberOfDice > 0){
            this.numberOfDice = numberOfDice;
            dice = new Die[numberOfDice];
            for (int i = 0; i < dice.length; i++) {
                dice[i] = new Die(random);
            }
        }else{
            logger.error("Illegal number of dice " + numberOfDice);
            throw new IllegalArgumentException("Illegal number of dice " + numberOfDice);
        }

    }

    public boolean isRolled() {
        logger.trace("isRolled() is called");
        return isRolled;
    }

    public int getTotal() {
        logger.trace("getTotal() is called");
        int total = 0;
        if (isRolled) {
            for (Die die : dice) {
                total += die.getValue();
            }
        }
        return total;
    }

    public Die[] getDice() {
        logger.trace("getDice() is called");
        return dice;
    }

    public void roll() {
        logger.trace("roll() is called");
        for (Die die : dice) {
            die.roll();
        }
        isRolled = true;
    }

    public void reset() {
        logger.trace("reset() is called");
        for (Die die : dice) {
            die.roll();
        }
        isRolled = false;
    }
}
