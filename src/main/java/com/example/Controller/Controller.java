package com.example.Controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PlayerController{

    PlayerRepository playerRepository =  new PlayerService();

  @GetMapping("/Players")
  public ArrayList<Player> getAllPlayer() {

        return playerRepository.getAllPlayers();
  }
  @PostMapping("/Players")
  public Player postPlayer(@RequestBody Player player) {
	  
	  return playerRepository.postPlayer( player);
	  
	  
	  
  }
  @GetMapping("/Players/{playerId}")
  public Player getPlayerId(@PathVariable("playerId") int playerId) {
	return playerRepository.getPlayerId(playerId);
	  
  }
  @PutMapping("/Players/{playerId}")
  public Player updatePlayerId(@PathVariable("playerId") int playerId,@RequestBody Player player) {
	return playerRepository.updatePlayer(playerId,player);
	  
  }
  @DeleteMapping("/Players/{playerId}")
  public void deletePlayer(@PathVariable("playerId") int playerId) {
	    playerRepository.deletePlayer(playerId);
	  
  }

}
