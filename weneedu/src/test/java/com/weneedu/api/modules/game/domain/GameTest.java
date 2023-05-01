package com.weneedu.api.modules.game.domain;

import com.weneedu.api.modules.player.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    List<Player> headlinePlayers;
    @BeforeEach
    private void setUp(){
        headlinePlayers = new ArrayList<>();
    }

    @Test
    void setHeadlinePlayers() {
    }

    @Test
    void setBenchPlayers() {
    }

    @Test
    void setRetiredPlayers() {
    }
}