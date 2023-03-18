package org.example.domain.model;

import java.util.Random;

public enum MoveOption {
    ROCK,
    PAPER,
    SCISSORS;

    private static final Random random = new Random();
    private static final MoveOption[] moveOptions = values();

    public static MoveOption randomMoveOption() {
        return moveOptions[random.nextInt(MoveOption.moveOptions.length)];
    }
}
