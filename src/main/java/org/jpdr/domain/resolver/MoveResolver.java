package org.jpdr.domain.resolver;

import org.jpdr.domain.model.MoveOption;
import org.jpdr.domain.rule.Rule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoveResolver {

    private final List<Rule> rules;

    public MoveResolver(List<Rule> rules) {
        this.rules = rules;
    }

    public Optional<MoveOption> resolveWinningMove(MoveOption player1moveOption, MoveOption palyer2MoveOption) {

        for (Rule rule: rules) {
            if (rule.isApplicable(player1moveOption, palyer2MoveOption)){
                return rule.getWinningMove();
            }
        }

        throw new RuntimeException("No game rule found with given player moves: " + player1moveOption + " - " + palyer2MoveOption);
    }

    public MoveOption resolveEnemyMove() {
        return MoveOption.randomMoveOption();
    }
}
