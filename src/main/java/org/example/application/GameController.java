package org.example.application;

import org.example.domain.handler.EndGameHandler;
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
    private final EndGameHandler endGameHandler;

    public GameController(StartGameHandler startGameHandler, EndGameHandler endGameHandler) {
        this.startGameHandler = startGameHandler;
        this.endGameHandler = endGameHandler;
    }

    @GetMapping(value = "/start", produces = "application/json")
    @ResponseBody
    public ResponseEntity<GameStartData> startGame() {
        // Return Instructions and the 3 Options for the game [rock, paper and scissors]
        return new ResponseEntity<>(startGameHandler.handleGameStartRequest(), HttpStatus.OK);
    }

    @PostMapping("/result")
    @ResponseBody
    public ResponseEntity<GameResultData> endGame(@RequestBody EndGameRequest request) {
        //TODO: add validation and/or exception handling
        PlayData playData = new PlayData(MoveOption.valueOf(request.playerMove().toUpperCase()));

        return new ResponseEntity<>(endGameHandler.handleEndGame(playData), HttpStatus.OK);

    }
}
