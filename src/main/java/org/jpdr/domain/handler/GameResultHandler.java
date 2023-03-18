package org.jpdr.domain.handler;

import org.jpdr.domain.resolver.GameResolver;
import org.jpdr.domain.model.GameResultData;
import org.jpdr.domain.model.PlayData;
import org.springframework.stereotype.Service;

@Service
public class GameResultHandler {

    private final GameResolver gameResolver;

    public GameResultHandler(GameResolver gameResolver) {
        this.gameResolver = gameResolver;
    }

    public GameResultData handlePlayData(PlayData playData) {
        return gameResolver.resolveResult(playData.moveOption());
    }
}
