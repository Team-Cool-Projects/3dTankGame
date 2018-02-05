/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.gg.server.controller.runnable;

import com.team142.gg.server.controller.runnable.base.AbstractTickerWorker;
import com.team142.gg.server.model.Player;
import com.team142.gg.server.model.Repository;
import com.team142.gg.server.model.mappable.artificial.Bullet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author just1689
 */
public class TickerPhysics extends AbstractTickerWorker {

    public TickerPhysics(String playerId, String gameId) {
        super(playerId, gameId);
    }

    @Override
    public void doTick() {
        Player player = Repository.PLAYERS_ON_SERVER.get(getPLAYER_ID());
        player.movementTick();

        player.getBULLETS()
                .stream()
                .filter((bullet) -> !bullet.movementTickBullet())
                .forEach(this::removeBullet);

    }

    private void removeBullet(Bullet bullet) {
        Logger.getLogger(TickerPhysics.class.getName()).log(Level.INFO, "Removing bullet");
        bullet.getPlayer().removeBullet(bullet);
    }

}
