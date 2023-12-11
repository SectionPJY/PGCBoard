package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ex.dao.ReviewDAO;

@Service
public class ReviewInsertCommand {

	@Autowired
	private ReviewDAO dao;

	public int execute(HttpServletRequest request) {
		System.out.println("========== Review Insert Command Running ==========");

		int r_uid = Integer.parseInt(request.getParameter("r_uid"));
		int r_gid = Integer.parseInt(request.getParameter("r_gid"));
		String r_content = request.getParameter("r_content");

		int result = dao.insertReview(r_uid, r_gid, r_content);
		if (1 == result)
			System.out.println("========== Insert Success ==========");
		else
			System.out.println("========== Insert Failed ==========");

		return result;
	}
}
