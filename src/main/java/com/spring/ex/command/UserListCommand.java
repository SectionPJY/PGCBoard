package com.spring.ex.command;

import com.spring.ex.dao.UserDAO;
import com.spring.ex.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class UserListCommand {

	@Autowired
	private UserDAO dao;

	public List<UserDTO> execute(Model model) {
		System.out.println("========== UserListCommand Running ==========");

		System.out.println("========== Unregistered User ==========");
		List<UserDTO> unReg = dao.unregUserList();
		System.out.println(unReg);

		System.out.println("========== UserList ==========");
		List<UserDTO> uList = dao.userList();
		System.out.println(uList);

		System.out.println("========== Rejection User List ==========");
		List<UserDTO> rList = dao.rejUserList();
		System.out.println(rList);

		model.addAttribute("unReg", unReg);
		model.addAttribute("uList", uList);
		model.addAttribute("rejList", rList);

		return uList;
	}
}
