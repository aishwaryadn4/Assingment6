package com.springbootcrud.service;

import java.util.*;

import com.springbootcrud.model.Player;

public interface PlayerService {
	
	
	List<Player> getAllPlayers();
	void savePlayer(Player player);
	
	Player getPlayerById(long id);
	void deletePlayerById(long id);

}
