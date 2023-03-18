package org.example.domain.rule;

import org.example.domain.model.MoveOption;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SameMoveRule implements Rule {

    @Override
    public boolean isApplicable(MoveOption player1Move, MoveOption player2Move) {
        return player1Move.equals(player2Move);
    }

    @Override
    public Optional<MoveOption> getWinningMove() {
        return Optional.empty();
    }
}
