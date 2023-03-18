package org.example.application.validator;

import org.example.application.GameResultRequest;
import org.example.application.exception.RequestValidationException;
import org.example.domain.model.MoveOption;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RequestValidator {

    public void validateGameResultRequest(GameResultRequest gameResultRequest) {
        try {
            MoveOption.valueOf(gameResultRequest.playerMove().toUpperCase());
        } catch (Exception exception) {
            throw new RequestValidationException("The given player move: " + gameResultRequest.playerMove() + " is invalid." +
                    "Valid options are: " + Arrays.toString(MoveOption.values()));
        }
    }
}
