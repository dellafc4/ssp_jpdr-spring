package org.example.domain.rule;

import org.example.domain.model.MoveOption;
import org.springframework.stereotype.Service;

@Service
public class RockScissorRule implements Rule {
    @Override
    public boolean isApplicableRule(MoveOption player1Move, MoveOption player2Move) {
        if (MoveOption.SCISSORS.equals(player1Move) && MoveOption.ROCK.equals(player2Move)) {
            return true;
        }

        return MoveOption.SCISSORS.equals(player2Move) && MoveOption.ROCK.equals(player1Move);
    }

    @Override
    public MoveOption getWinningMove() {
        return MoveOption.ROCK;
    }
}
