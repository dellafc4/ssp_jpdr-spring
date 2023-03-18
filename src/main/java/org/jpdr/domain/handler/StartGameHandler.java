package org.jpdr.domain.handler;

import org.jpdr.domain.model.GameStartData;
import org.jpdr.domain.model.MoveOption;
import org.springframework.stereotype.Service;

@Service
public class StartGameHandler {

    private final static String GAME_TITLE = "'Rock paper scissors' - The game";
    private final static String INSTRUCTIONS = """
            When you are ready to play against the computer 'Enemy' simply press the 'Let's play' button below.
            The enemy is always watching you, so just pick a move and he will pick one too!
            In addition you can play as many times as you want.
            """;
    private final static String GAME_RULES = """
            In case you need a refresher, these are the rules:
                1. rock wins against scissors
                2. scissors wins against paper
                3. paper wins against rock
                4. same move means a tie
            """;
    public GameStartData handleGameStartRequest() {
        return new GameStartData(
                GAME_TITLE,
                INSTRUCTIONS,
                GAME_RULES,
                MoveOption.values()
        );
    }
}
