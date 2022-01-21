package ca.tetervak.diceroller.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Random;

public class Die implements Serializable {

    private final Logger logger = LoggerFactory.getLogger(Die.class);

    private int value = 1;

    private final Random random;

    public Die(){
        this(new Random());
        logger.trace("Die() is called.");
    }

    public Die(Random random){
        this.random = random;
        logger.trace("Die(Random random) constructor is called.");
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        logger.trace("setNumber() is called.");
        logger.debug("number = " + value);
        this.value = value;
    }

    public void rollDie(){
        logger.trace("rollDie() is called");
        value = 1 + random.nextInt(6);
        logger.debug("number = " + value);
    }
}
