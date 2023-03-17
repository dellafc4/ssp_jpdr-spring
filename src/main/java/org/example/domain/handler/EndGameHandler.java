package org.example.domain.handler;

import org.example.domain.resolver.GameResolver;
import org.example.domain.model.GameResultData;
import org.example.domain.model.PlayData;
import org.springframework.stereotype.Service;

@Service
public class EndGameHandler {

    private final GameResolver gameResolver;

    public EndGameHandler(GameResolver gameResolver) {
        this.gameResolver = gameResolver;
    }

    public GameResultData handleEndGame(PlayData playData) {
        return gameResolver.resolveResult(playData.moveOption());
    }
}
