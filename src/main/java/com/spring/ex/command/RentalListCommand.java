package com.spring.ex.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.ex.dao.RentalDAO;
import com.spring.ex.dto.RentalDTO;

@Service
public class RentalListCommand {

	@Autowired
	private RentalDAO dao;

	public List<RentalDTO> execute(Model model, int offset) {
		System.out.println("========== Rental List Command Running ==========");
		
		List<RentalDTO> renList = dao.rentalList(offset);
		model.addAttribute("renList", renList);

		List<RentalDTO> returnList = dao.returnList(offset);
		model.addAttribute("returnList", returnList);

		return renList;
	}
}
