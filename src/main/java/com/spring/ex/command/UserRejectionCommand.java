package com.spring.ex.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ex.dao.UserDAO;

@Service
public class UserRejectionCommand {

	@Autowired
	private UserDAO dao;

	public int execute(String u_id) {
		System.out.println("========== User Rejection Command Running ==========");
		System.out.println("ID : " + u_id);

		int result = dao.userRej(u_id);
		if (1 == result)
			System.out.println("========== User Rejection Success ==========");
		else
			System.out.println("========== User Rejection Failed ==========");

		return result;
	}
}
