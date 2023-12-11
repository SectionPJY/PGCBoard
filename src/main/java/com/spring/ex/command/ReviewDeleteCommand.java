package com.spring.ex.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ex.dao.ReviewDAO;

@Service
public class ReviewDeleteCommand {

	@Autowired
	private ReviewDAO dao;

	public int execute(int r_id) {
		System.out.println("========== Review Delete Command Running ==========");

		int result = dao.reviewDelete(r_id);
		if (1 == result)
			System.out.println("Delete Success");
		else
			System.out.println("Delete Fail");

		return result;
	}
}
