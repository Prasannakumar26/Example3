package com.example.Controller;

import java.util.ArrayList;

public interface PlayerRepository {
	ArrayList<Player> getAllPlayers();
	Player postPlayer(Player player);
	Player getPlayerId(int playerId);
	Player updatePlayer(int playerId,Player player);
    void deletePlayer(int playerId);
}
