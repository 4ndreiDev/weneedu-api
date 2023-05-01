package com.weneedu.api.modules.game.domain;

public class NonAvailablePlaceException extends RuntimeException {
    public NonAvailablePlaceException(String message) {
        super(message);
    }
}
