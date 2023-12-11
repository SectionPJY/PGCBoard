package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.ex.dao.UserDAO;

@Service
public class SignUpCheckCommand {

	@Autowired
	private UserDAO dao;

	public int execute(Model model) {
		System.out.println("========== SignUp Check Command Running ==========");
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String u_id = request.getParameter("u_uid");
		int idCheck = dao.idDupCheck(u_id);
		if (idCheck > 0) {
			System.out.println("========== Duplicate ID ==========");

			return 3;
		}

		String u_pw = request.getParameter("u_pw");
		String u_name = request.getParameter("u_name");
		int u_age = Integer.parseInt(request.getParameter("u_age"));
		String u_phone = phone_format(request.getParameter("u_phone"));

		int result = dao.signUpCheck(u_id, u_pw, u_name, u_age, u_phone);
		if (1 == result) {
			System.out.println("========== SignUp Success ==========");
		} else {
			System.out.println("========== SignUp Failed ==========");
		}

		return result;
	}

	public String phone_format(String number) {
		String regEx = "(\\d{3})(\\d{3,4})(\\d{4})";
		return number.replaceAll(regEx, "$1-$2-$3");
	}
}
