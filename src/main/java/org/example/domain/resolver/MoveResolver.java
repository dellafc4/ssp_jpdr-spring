package org.example.domain.resolver;

import org.example.domain.model.MoveOption;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MoveResolver {

    public Optional<MoveOption> resolveWinningMove(MoveOption player1moveOption, MoveOption palyer2MoveOption) {

        if (player1moveOption.equals(palyer2MoveOption)) {
            return Optional.empty();
        }

        if (isRockPaperRule(player1moveOption, palyer2MoveOption)) {
            return Optional.of(MoveOption.PAPER);
        }

        if (isRockScissorRule(player1moveOption, palyer2MoveOption)) {
            return Optional.of(MoveOption.ROCK);
        }

        return Optional.of(MoveOption.SCISSORS);
    }

    private boolean isRockPaperRule(MoveOption player1moveOption, MoveOption palyer2MoveOption) {
        if (MoveOption.PAPER.equals(player1moveOption) && MoveOption.ROCK.equals(palyer2MoveOption)) {
            return true;
        }

        return MoveOption.PAPER.equals(palyer2MoveOption) && MoveOption.ROCK.equals(player1moveOption);
    }

    private boolean isRockScissorRule(MoveOption player1moveOption, MoveOption palyer2MoveOption) {
        if (MoveOption.SCISSORS.equals(player1moveOption) && MoveOption.ROCK.equals(palyer2MoveOption)) {
            return true;
        }

        return MoveOption.SCISSORS.equals(palyer2MoveOption) && MoveOption.ROCK.equals(player1moveOption);
    }



}
