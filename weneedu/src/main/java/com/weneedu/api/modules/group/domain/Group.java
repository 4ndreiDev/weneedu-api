package com.weneedu.api.modules.group.domain;

import com.weneedu.api.modules.player.domain.Player;
import com.weneedu.api.shared.domain.valueobjects.Location;

import java.time.LocalDateTime;
import java.util.SortedSet;
import java.util.UUID;

public record Group(UUID id, String name, String description, LocalDateTime createdAt, Player createdBy, Location location, GroupType groupType, SortedSet<Player> members, SortedSet<Player> memberRequests) {

    public void join(Player player) {
        memberRequests.add(player);
    }
    public void leave(Player player) {
        members.remove(player);
        memberRequests.remove(player);
    }
    public boolean acceptRequest(Player player){
        memberRequests.remove(player);
        return members.add(player);
    }
}
