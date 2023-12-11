package com.spring.ex.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ex.dao.UserDAO;

@Service
public class UserApprovalCommand {

	@Autowired
	private UserDAO dao;

	public int execute(String u_id) {
		System.out.println("========== User Approval Command Running ==========");
		System.out.println("ID : " + u_id);

		int result = dao.userApp(u_id);
		if (1 == result)
			System.out.println("========== User Approval Success ==========");
		else
			System.out.println("========== User Approval Failed ==========");

		return result;
	}
}
