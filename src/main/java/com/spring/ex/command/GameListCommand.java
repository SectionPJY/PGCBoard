package com.spring.ex.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.ex.dao.GameDAO;
import com.spring.ex.dto.GameDTO;

@Service
public class GameListCommand {

	@Autowired
	private GameDAO dao;

	public List<GameDTO> execute(Model model) {

		System.out.println("========== Game List Command ==========");
		List<GameDTO> dtos = dao.gameList();
		System.out.println(dtos);

		model.addAttribute("gameList", dtos);

		return dtos;
	}

}
