package ca.tetervak.diceroller.domain;

import java.io.Serializable;

public class Game implements Serializable {

    private int numberOfDice;
    private Die[] dice;

    public Game(){
        setNumberOfDice(3);
    }

    public Game(int numberOfDice){
        setNumberOfDice(numberOfDice);
    }

    public int getNumberOfDice(){
        return numberOfDice;
    }

    public final void setNumberOfDice(int numberOfDice){
        this.numberOfDice = numberOfDice;
        dice = new Die[numberOfDice];
        for(int i = 0; i < dice.length; i++){
            dice[i] = new Die();
        }
    }

    public int getTotal(){
        int total = 0;
        for(Die die: dice){
            total += die.getValue();
        }
        return total;
    }

    public Die[] getDice(){
        return dice;
    }

    public void rollDice(){
        for(Die die: dice){
            die.rollDie();
        }
    }
}
