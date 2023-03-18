package org.example.domain.rule;

import org.example.domain.model.MoveOption;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RockScissorRule implements Rule {
    @Override
    public boolean isApplicable(MoveOption player1Move, MoveOption player2Move) {
        if (MoveOption.SCISSORS.equals(player1Move) && MoveOption.ROCK.equals(player2Move)) {
            return true;
        }

        return MoveOption.SCISSORS.equals(player2Move) && MoveOption.ROCK.equals(player1Move);
    }

    @Override
    public Optional<MoveOption> getWinningMove() {
        return Optional.of(MoveOption.ROCK);
    }
}
