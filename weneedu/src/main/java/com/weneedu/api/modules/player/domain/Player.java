package com.weneedu.api.modules.player.domain;

import com.weneedu.api.modules.game.domain.Game;
import com.weneedu.api.shared.domain.valueobjects.Location;

import java.util.List;
import java.util.UUID;

public record Player (UUID id,String name, Location currentLocation, Player addedBy, List<Game> games){

}
