/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team142.gg.server.controller.runnable.powers;

import com.team142.gg.server.controller.GameManager;
import com.team142.gg.server.model.Game;
import com.team142.gg.server.model.Player;
import com.team142.gg.server.model.Repository;
import com.team142.gg.server.model.mappable.artificial.Bullet;

/**
 *
 * @author just1689
 */
public class Power1Shoot extends Power {

    public Power1Shoot(Player player, long refreshTime) {
        super(player, 0, refreshTime);
    }

    @Override
    public void execute() {

    }

    public void playerAttemptsToShoot() {

        //Check last shot
        if (System.currentTimeMillis() - getPlayer().getLAST_BULLET().get() >= getPlayer().getMS_PER_SHOT()) {
            //We can shoot
            getPlayer().getLAST_BULLET().set(System.currentTimeMillis());
            playerShoots();

        }

    }

    public void playerShoots() {
        Game game = Repository.GAMES_ON_SERVER.get(getPlayer().getGameId());

        //Change state
        Bullet bullet = getPlayer().createBullet();

        //Communicate
        GameManager.sendBullet(game, bullet);
        game.getSoundManager().sendShoot();

    }

}
