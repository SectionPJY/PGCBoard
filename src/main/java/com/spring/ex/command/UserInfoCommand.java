package com.spring.ex.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.ex.dao.UserDAO;
import com.spring.ex.dto.UserDTO;

@Service
public class UserInfoCommand {

	@Autowired
	private UserDAO dao;

	public List<UserDTO> execute(Model model, int u_id) {
		System.out.println("========== User Info Command Running ==========");
		List<UserDTO> dto = dao.userInfo(u_id);

		if (dto.isEmpty()) {
			System.out.println("========== User Information Loading Failed ==========");
			System.out.println(dto);

			return dto;
		} else {
			System.out.println("========== User Information Loading Success ==========");
			model.addAttribute("userInfo", dto);

			return dto;
		}
	}
}
