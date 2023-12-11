package com.spring.ex.command;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.ex.dao.GameDAO;
import com.spring.ex.dto.GameDTO;

@Service
public class GameInfoCommand {

	@Autowired
	private GameDAO dao;

	public List<GameDTO> execute(Model model, String g_id) {
		System.out.println("========== Game Select Command Running ==========");
		System.out.println("GID : " + g_id);
		List<GameDTO> dto = dao.selectGame(Integer.parseInt(g_id));

		if (dto.isEmpty()) {
			System.out.println("========== Game Select Failed ==========");
			System.out.println(dto);
		} else {
			System.out.println("========== Game Select Success ==========");
			model.addAttribute("game", dto);
		}

		return dto;
	}

}
