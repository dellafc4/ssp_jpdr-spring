package org.example.application;

import org.example.application.validator.RequestValidator;
import org.example.domain.handler.GameResultHandler;
import org.example.domain.model.GameResultData;
import org.example.domain.model.GameStartData;
import org.example.domain.handler.StartGameHandler;
import org.example.domain.model.MoveOption;
import org.example.domain.model.PlayData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
@CrossOrigin(origins = "http://localhost:4200")
public class GameController {

    private final StartGameHandler startGameHandler;
    private final GameResultHandler gameResultHandler;
    private final RequestValidator requestValidator;

    public GameController(StartGameHandler startGameHandler, GameResultHandler gameResultHandler, RequestValidator requestValidator) {
        this.startGameHandler = startGameHandler;
        this.gameResultHandler = gameResultHandler;
        this.requestValidator = requestValidator;
    }

    @GetMapping(value = "/start", produces = "application/json")
    @ResponseBody
    public ResponseEntity<GameStartData> startGame() {
        return new ResponseEntity<>(startGameHandler.handleGameStartRequest(), HttpStatus.OK);
    }

    @PostMapping("/result")
    @ResponseBody
    public ResponseEntity<GameResultData> gameResult(@RequestBody GameResultRequest request) {

        requestValidator.validateGameResultRequest(request);

        PlayData playData = new PlayData(MoveOption.valueOf(request.playerMove().toUpperCase()));

        return new ResponseEntity<>(gameResultHandler.handlePlayData(playData), HttpStatus.OK);

    }
}
