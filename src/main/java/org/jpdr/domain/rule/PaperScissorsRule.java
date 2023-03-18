package org.jpdr.domain.rule;

import org.jpdr.domain.model.MoveOption;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaperScissorsRule implements Rule {
    @Override
    public boolean isApplicable(MoveOption player1Move, MoveOption player2Move) {
        if (MoveOption.PAPER.equals(player1Move) && MoveOption.SCISSORS.equals(player2Move)) {
            return true;
        }

        return MoveOption.PAPER.equals(player2Move) && MoveOption.SCISSORS.equals(player1Move);
    }

    @Override
    public Optional<MoveOption> getWinningMove() {
        return Optional.of(MoveOption.SCISSORS);
    }
}
