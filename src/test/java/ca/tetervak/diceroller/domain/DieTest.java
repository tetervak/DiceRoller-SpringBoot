package ca.tetervak.diceroller.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DieTest {

    private static final long SEED = 45;
    private static Random random;
    private Die die;

    @BeforeAll
    static void prepare(){
        random = new Random();
        random.setSeed(SEED);
    }

    @BeforeEach
    void setUp() {
        die = new Die(random);
    }

    @Test
    void setValue_five() {
        int value = 5;
        assertEquals(Die.INIT_DIE_VALUE, die.getValue());
        die.setValue(value);
        assertEquals(value, die.getValue());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void setValue_valid(int value) {
        assertEquals(Die.INIT_DIE_VALUE, die.getValue());
        die.setValue(value);
        assertEquals(value, die.getValue());
    }

    @Test
    void setValue_zero() {
        int value = 0;
        assertEquals(Die.INIT_DIE_VALUE, die.getValue());
        assertThrows(IllegalArgumentException.class, () -> die.setValue(value));
    }

    @Test
    void setValue_seven() {
        int value = 7;
        assertEquals(Die.INIT_DIE_VALUE, die.getValue());
        assertThrows(IllegalArgumentException.class, () -> die.setValue(value));
    }

    @Test
    void roll() {
        assertFalse(die.isRolled());
        assertEquals(Die.INIT_DIE_VALUE, die.getValue());
        die.roll();
        assertTrue(die.isRolled());
        int value = die.getValue();
        assertTrue(value >= 1);
        assertTrue(value <= 6);
    }

    @RepeatedTest(10)
    void roll_ten_times() {
        roll();
    }

    @Test
    void reset() {
        int value = 4;
        die.roll();
        die.setValue(value);
        die.reset();
        assertEquals(Die.INIT_DIE_VALUE, die.getValue());
        assertFalse(die.isRolled());
    }

}