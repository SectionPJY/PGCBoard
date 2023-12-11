package com.spring.ex.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.ex.dao.ReviewDAO;
import com.spring.ex.dto.ReviewDTO;

@Service
public class ReviewListCommand {

	@Autowired
	private ReviewDAO dao;

	public List<ReviewDTO> execute(Model model, int startNum) {
		System.out.println("========== Review List Command Running =========");

		List<ReviewDTO> dtos = dao.reviewList(startNum);
		if (dtos.isEmpty()) {
			System.out.println("========== List is Empty ==========");

			return null;
		} else {
			System.out.println(dtos.get(0).getU_name());
			model.addAttribute("reviewList", dtos);

			return dtos;
		}
	}
}
