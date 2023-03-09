package com.example.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class PlayerService implements PlayerRepository {

	int incnumber = 12;

    public  HashMap<Integer, Player> team = new HashMap<>();

    public PlayerService() {
        team.put(1, new Player(1, "Alexander", 5, "All-rounder"));
        team.put(2, new Player(2, "Benjamin", 3, "All-rounder"));
        team.put(3, new Player(3, "Michael", 18, "Batsman"));
        team.put(4, new Player(4, "William", 45, "Batsman"));
        team.put(5, new Player(5, "Joshua", 19, "Batsman"));
        team.put(6, new Player(6, "Daniel", 10, "Bowler"));
        team.put(7, new Player(7, "Matthew", 34, "Bowler"));
        team.put(8, new Player(8, "Samuel", 17, "Batsman"));
        team.put(9, new Player(9, "John", 1, "Bowler"));
        team.put(10, new Player(10, "Earnest", 2, "All-rounder"));
        team.put(11, new Player(11, "Bob", 25, "Batsman"));
    }
    @Override
    public ArrayList<Player> getAllPlayers() {
       Collection<Player> collection = team.values();
       ArrayList<Player> arr1 = new ArrayList<Player>(collection);


    return arr1;
    }
	@Override
	public Player postPlayer(Player player) {
		 player.setPlayerId(incnumber);
		 team.put(incnumber, player);
		 incnumber += 1;
		return player;
	}
	@Override
	public Player getPlayerId(int playerId) {
		Player player = team.get(playerId);
		if(player == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return player;
	}
	@Override
	public Player updatePlayer(int playerId, Player player) {
		     Player existingPlayer = team.get(playerId);
		     if(existingPlayer == null) {
		    	 throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		     }
		     if(player.getPlayerName() != null) {
		    	 existingPlayer.setPlayerName(player.getPlayerName());
		     }
		     if(player.getRole() != null) {
		    	 existingPlayer.setRole(player.getRole());
		     }
		return existingPlayer;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void deletePlayer(int playerId) {
		   Player player  = team.get(playerId);
		   if(player == null) {
			   throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		   }else {
			   team.remove(player);
			   throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		   }
		
	}
	
	

}