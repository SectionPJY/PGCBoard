package com.spring.ex.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ex.dao.GameDAO;

@Service
public class GameRentalCommand {

	@Autowired
	private GameDAO dao;
	
	public int execute(int g_id) {
		System.out.println("========== Game Rental Command Running ==========");
		int result = dao.rentalGame(g_id);
		
		return result;
	}
}
