package com.spring.ex.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.ex.dao.GameDAO;

@Service
public class GameInsertCommand {

	@Autowired
	private GameDAO dao;

	public int execute(MultipartHttpServletRequest request) {
		System.out.println("========== Game Insert Command Running ==========");

		String g_name = request.getParameter("g_name");
		String g_content = request.getParameter("g_content");

		int result = dao.insertGame(g_name, g_content);
		if(1==result)
			System.out.println("========== Game Insert Success ==========");
		else
			System.out.println("========== Game Insert Fail ==========");
		
		return result;
	}

}
