package org.example.domain.rule;

import org.example.domain.model.MoveOption;
import org.springframework.stereotype.Service;

@Service
public class RockPaperRule implements Rule {
    @Override
    public boolean isApplicableRule(MoveOption player1Move, MoveOption player2Move) {
        if (MoveOption.PAPER.equals(player1Move) && MoveOption.ROCK.equals(player2Move)) {
            return true;
        }

        return MoveOption.PAPER.equals(player2Move) && MoveOption.ROCK.equals(player1Move);
    }

    @Override
    public MoveOption getWinningMove() {
        return MoveOption.PAPER;
    }
}
