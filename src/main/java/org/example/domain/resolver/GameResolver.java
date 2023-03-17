package org.example.domain.resolver;

import org.example.domain.model.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameResolver {

    private final MoveResolver moveResolver;

    public GameResolver(MoveResolver gameRulesChecker) {
        this.moveResolver = gameRulesChecker;
    }

    public GameResultData resolveResult(MoveOption playerMove) {

        MoveOption enemyMove = MoveOption.randomMoveOption();

        Optional<MoveOption> winnerMove = moveResolver.resolveWinningMove(playerMove, enemyMove);

        if (winnerMove.isEmpty()) {
            return createGameResultData(GameEndOption.TIE, enemyMove);
        }

        return playerMove.equals(winnerMove.get()) ? createGameResultData(GameEndOption.PLAYER_WINS, enemyMove) : createGameResultData(GameEndOption.ENEMY_WINS, enemyMove);
    }

    //TODO: refactor
    private GameResultData createGameResultData(GameEndOption gameEndOption, MoveOption moveOption) {
        return new GameResultData(gameEndOption, moveOption);
    }
}
