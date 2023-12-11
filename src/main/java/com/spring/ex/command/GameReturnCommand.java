package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.ex.dao.GameDAO;

@Service
public class GameReturnCommand {

	@Autowired
	private GameDAO dao;

	public int execute(Model model) {
		System.out.println("========== Return Game Command Running ==========");
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int g_id = Integer.parseInt(request.getParameter("g_id"));
		int result = dao.returnGame(g_id);
		if (1 == result)
			System.out.println("========== Return Success ==========");
		else
			System.out.println("========== Return Failed ==========");

		return result;
	}

	public int execute(int u_id, int g_id) {
		System.out.println("========== Return Game Command Running ==========");

		int result = dao.returnGame(u_id, g_id);
		if (1 == result)
			System.out.println("========== Return Success ==========");
		else
			System.out.println("========== Return Failed ==========");

		return result;
	}
}
