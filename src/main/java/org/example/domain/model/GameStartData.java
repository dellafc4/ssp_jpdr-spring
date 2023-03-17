package org.example.domain.model;

public record GameStartData(String gameTitle,
                            String instructions,
                            String gameRules,
                            MoveOption[] moveOptions) {
}
