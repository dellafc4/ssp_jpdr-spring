package org.example.domain.resolver;

import org.apache.tomcat.util.digester.Rules;
import org.example.domain.model.MoveOption;
import org.example.domain.rule.PaperScissorsRule;
import org.example.domain.rule.RockPaperRule;
import org.example.domain.rule.RockScissorRule;
import org.example.domain.rule.Rule;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GameRulesCheckerTest {

    List<Rule> rules = new ArrayList<>(Arrays.asList(
            new PaperScissorsRule(),
            new RockScissorRule(),
            new RockPaperRule())
    );
    MoveResolver gameRulesChecker = new MoveResolver(rules);
    @Test
    void assertRulesWorkingAsExpecte() {
        Optional<MoveOption> moveOption = gameRulesChecker.resolveWinningMove(MoveOption.ROCK, MoveOption.SCISSORS);
        assertEquals(MoveOption.ROCK, moveOption.get());

        Optional<MoveOption> moveOption2 = gameRulesChecker.resolveWinningMove(MoveOption.ROCK, MoveOption.PAPER);
        assertEquals(MoveOption.PAPER, moveOption2.get());

        Optional<MoveOption> moveOption3= gameRulesChecker.resolveWinningMove(MoveOption.ROCK, MoveOption.ROCK);
        assertTrue( moveOption3.isEmpty());



        Optional<MoveOption> moveOption4 = gameRulesChecker.resolveWinningMove(MoveOption.SCISSORS, MoveOption.ROCK);
        assertEquals(MoveOption.ROCK, moveOption4.get());

        Optional<MoveOption> moveOption5 = gameRulesChecker.resolveWinningMove(MoveOption.SCISSORS, MoveOption.PAPER);
        assertEquals(MoveOption.SCISSORS, moveOption5.get());

        Optional<MoveOption> moveOption6= gameRulesChecker.resolveWinningMove(MoveOption.SCISSORS, MoveOption.SCISSORS);
        assertTrue(moveOption6.isEmpty());



        Optional<MoveOption> moveOption7 = gameRulesChecker.resolveWinningMove(MoveOption.PAPER, MoveOption.ROCK);
        assertEquals(MoveOption.PAPER, moveOption7.get());

        Optional<MoveOption> moveOption8 = gameRulesChecker.resolveWinningMove(MoveOption.PAPER, MoveOption.SCISSORS);
        assertEquals(MoveOption.SCISSORS, moveOption8.get());

        Optional<MoveOption> moveOption9= gameRulesChecker.resolveWinningMove(MoveOption.PAPER, MoveOption.PAPER);
        assertTrue(moveOption9.isEmpty());



        Optional<MoveOption> moveOption10 = gameRulesChecker.resolveWinningMove(MoveOption.SCISSORS, MoveOption.ROCK);
        assertEquals(MoveOption.ROCK, moveOption10.get());

        Optional<MoveOption> moveOption11 = gameRulesChecker.resolveWinningMove(MoveOption.PAPER, MoveOption.ROCK);
        assertEquals(MoveOption.PAPER, moveOption11.get());

        Optional<MoveOption> moveOption12= gameRulesChecker.resolveWinningMove(MoveOption.ROCK, MoveOption.ROCK);
        assertTrue( moveOption12.isEmpty());
    }

}