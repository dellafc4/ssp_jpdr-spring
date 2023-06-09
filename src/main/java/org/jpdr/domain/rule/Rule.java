package org.jpdr.domain.rule;

import org.jpdr.domain.model.MoveOption;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface Rule {
    boolean isApplicable(MoveOption player1Move, MoveOption player2Move);
    Optional<MoveOption> getWinningMove();
}
