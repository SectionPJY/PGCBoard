package com.spring.ex.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.ex.dao.RentalDAO;
import com.spring.ex.dto.RentalDTO;

@Service
public class RentalSelectCommand {

	@Autowired
	private RentalDAO dao;

	public List<RentalDTO> execute(Model model, int u_id) {
		System.out.println("========== Rental Select Command Running ==========");
		List<RentalDTO> dtos = dao.selectRental(u_id);
		
		System.out.println(dtos);

		model.addAttribute("rentList", dtos);
		
		return dtos;
	}
}
