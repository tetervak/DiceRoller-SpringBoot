package ca.tetervak.diceroller.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Random;


public class Die implements Serializable {

    private final Logger logger = LoggerFactory.getLogger(Die.class);

    private int number = 1;

    private final Random random = new Random();

    public Die(){
        logger.trace("The constructor is called.");
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        logger.trace("setNumber() is called.");
        this.number = number;
    }

    public void rollDie(){
        logger.trace("rollDie() is called");
        number = 1 + random.nextInt(6);
        logger.debug("number = " + number);
    }
}
