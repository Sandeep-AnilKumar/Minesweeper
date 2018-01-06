package com.minesweeper;

/**
 * @author sandeepa
 */

public enum Mine {
    DANGER ('X'),
    CAUTION ('!'),
    SAFE ('~');

    private char state;

    Mine(char state) {
        this.state = state;
    }

    public char getState() {
        return state;
    }

    @Override
    public String toString() {
        return this.state + "";
    }
}
