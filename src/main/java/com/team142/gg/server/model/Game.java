/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.gg.server.model;

import com.team142.gg.server.controller.Referee;
import com.team142.gg.server.model.mappable.MapTileElement;
import com.team142.gg.server.model.mappable.MovableElement;
import com.team142.gg.server.model.messages.outgoing.other.MessageGameSummary;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Value;

/**
 *
 * @author just1689
 *
 * A game will be where game state is managed.
 */
@Value
public class Game {

    private final String id;
    private final List<Player> players = Collections.synchronizedList(new ArrayList<>());
    private final String name;
    private final ConcurrentHashMap<String, MovableElement> elements = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, MapTileElement> map = new ConcurrentHashMap<>();

    public Game(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;

    }

    public MessageGameSummary toGameSummary() {
        return new MessageGameSummary(id, name, players.size());
    }

    public boolean hasPlayer(String id) {
        return players.stream().anyMatch((player) -> (player.getId().equals(id)));
    }

    public void removePlayer(String id) {
        players.removeIf(player -> player.getId().equals(id));

    }

    public void playerJoins(Player player) {

        MovableElement tank = new MovableElement(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ZERO, "default", BigDecimal.ZERO);
        elements.put(player.getId(), tank);

        players.add(player);
        Referee.announcePlayerJoins(this, player);

    }

}
