package ca.tetervak.diceroller.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Random;

public class Die implements Serializable {

    private final Logger logger = LoggerFactory.getLogger(Die.class);

    public static final int INIT_DIE_VALUE = 1;

    private int value = INIT_DIE_VALUE;
    private boolean isRolled = false;

    private final Random random;

    public Die(){
        this(new Random());
    }

    public Die(Random random){
        this.random = random;
        logger.trace("Die constructor is called.");
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        logger.trace("setNumber() is called.");
        logger.debug("value = " + value);
        if(value >= 1 && value <= 6){
            this.value = value;
        }else{
            logger.error("Illegal die value " + value);
            throw new IllegalArgumentException("Illegal die value " + value);
        }
    }

    public boolean isRolled() {
        return isRolled;
    }

    public void roll(){
        logger.trace("roll() is called");
        value = 1 + random.nextInt(6);
        isRolled = true;
        logger.debug("number = " + value);
    }

    public void reset(){
        logger.trace("reset() is called");
        isRolled = false;
        value = INIT_DIE_VALUE;
    }
}
