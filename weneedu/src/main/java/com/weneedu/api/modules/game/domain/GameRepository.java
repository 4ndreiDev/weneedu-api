package com.weneedu.api.modules.game.domain;

import java.util.Optional;
import java.util.SortedSet;

public interface GameRepository {
    Optional<Game> findById(Long id);

    SortedSet<Game> findAllByType(GameType type);
    SortedSet<Game> findAllByTypeAndNameContainingIgnoreCase(GameType type, String name);
}
