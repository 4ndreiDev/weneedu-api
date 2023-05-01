package com.weneedu.api.modules.game.domain;

import com.weneedu.api.modules.player.domain.Player;
import com.weneedu.api.shared.domain.valueobjects.Location;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.SortedSet;
import java.util.UUID;

@Slf4j
public record Game(UUID id, String name, String description, Location location, int allowedNumberOfHeadlinePlayers,
                   int numberOfTeams, LocalDateTime createdAt, LocalDateTime startDate, GameType gameType, Player createdBy, SortedSet<Player> headlinePlayers,
                   SortedSet<Player> benchPlayers, SortedSet<Player> retiredPlayers) {
    public boolean join(Player player) {
        if (headlinePlayers.size() >= allowedNumberOfHeadlinePlayers && benchPlayers.size() >= allowedNumberOfHeadlinePlayers) {
            log.info("Bench and Headline players list is full, Headline Players : {}, Bench Players: {}", headlinePlayers.size(), benchPlayers.size());
            throw new NonAvailablePlaceException("There are no available seats in this game");
        }

        if (headlinePlayers.size() < allowedNumberOfHeadlinePlayers) {
            return addHeadlinePlayer(player);
        }
        return addBenchPlayer(player);
    }

    public boolean leave(Player player) {
        return addRetiredPlayer(player);
    }

    private boolean addHeadlinePlayer(Player player) {
        benchPlayers.remove(player);
        retiredPlayers.remove(player);
        return headlinePlayers.add(player);
    }

    private boolean addBenchPlayer(Player player) {
        benchPlayers.remove(player);
        headlinePlayers.remove(player);
        return headlinePlayers.add(player);
    }

    private boolean addRetiredPlayer(Player player) {
        headlinePlayers.remove(player);
        benchPlayers.remove(player);
        return retiredPlayers.add(player);
    }

}
