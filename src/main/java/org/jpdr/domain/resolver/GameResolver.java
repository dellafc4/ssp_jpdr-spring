package org.jpdr.domain.resolver;

import org.jpdr.domain.model.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameResolver {

    private final MoveResolver moveResolver;

    public GameResolver(MoveResolver gameRulesChecker) {
        this.moveResolver = gameRulesChecker;
    }

    public GameResultData resolveResult(MoveOption playerMove) {

        MoveOption enemyMove = moveResolver.resolveEnemyMove();
        Optional<MoveOption> winnerMove = moveResolver.resolveWinningMove(playerMove, enemyMove);

        if (winnerMove.isEmpty()) {
            return createGameResultData(GameOutcomeValue.TIE, enemyMove);
        }

        return playerMove.equals(winnerMove.get()) ? createGameResultData(GameOutcomeValue.PLAYER_WINS, enemyMove) : createGameResultData(GameOutcomeValue.ENEMY_WINS, enemyMove);
    }

    private GameResultData createGameResultData(GameOutcomeValue gameOutcomeOption, MoveOption moveOption) {
        return new GameResultData(gameOutcomeOption, moveOption);
    }
}
