package com.spring.ex.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.ex.dao.ReviewDAO;
import com.spring.ex.dto.ReviewDTO;

@Service
public class ReviewSelectCommand {

	@Autowired
	private ReviewDAO dao;
	
	public List<ReviewDTO> execute(Model model, String g_id) {
		System.out.println("========== Review Select Command Running ==========");
		
		List<ReviewDTO> dtos = dao.selectReview(Integer.parseInt(g_id));
		
		model.addAttribute("reviewList", dtos);
		
		return dtos;
	}
}
