package org.example.domain.rule;

import org.example.domain.model.MoveOption;

public interface Rule {
    boolean isApplicableRule(MoveOption player1Move, MoveOption player2Move);
    MoveOption getWinningMove();
}
