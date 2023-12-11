package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.ex.dao.GameDAO;

@Service
public class GameUpdateCommand {

	@Autowired
	private GameDAO dao;

	public int execute(Model model) {
		System.out.println("========== Update Game Command Running ==========");
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int g_id = Integer.parseInt(request.getParameter("g_id"));
		String g_name = request.getParameter("g_name");
		String g_content = request.getParameter("g_content");

		int result = dao.updateGame(g_id, g_name, g_content);
		if (1 == result)
			System.out.println("========== Update Success ==========");
		else
			System.out.println("========== Update Failed ==========");

		return result;
	}
}
