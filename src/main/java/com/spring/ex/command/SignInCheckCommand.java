package com.spring.ex.command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.ex.dao.UserDAO;
import com.spring.ex.dto.UserDTO;

@Service
public class SignInCheckCommand {

	@Autowired
	private UserDAO dao;

	public int execute(Model model) {
		System.out.println("========== SignIn Check Command Running ==========");
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		int userReg = dao.userRegCheck(id);
		if (0 == userReg) {
			System.out.println("========== Unragistration User ==========");

			return 3;
		} else if (2 == userReg) {
			System.out.println("========== Suspended User ==========");

			return 4;
		}
		System.out.println("========== Registered User ==========");

		int result = dao.signinCheck(id, pw);
		if (1 == result) {
			System.out.println("========== SignIn Success ==========");
			System.out.println("========== Session Create ==========");

			List<UserDTO> dto = dao.signInInfo(id);
			for (UserDTO user : dto) {
				session.setAttribute("u_id", user.getU_id());
				session.setAttribute("u_uid", user.getU_uid());
				session.setAttribute("u_pw", user.getU_pw());
				session.setAttribute("u_name", user.getU_name());
				session.setAttribute("u_mode", user.getU_mode());
			}
			
			System.out.println("========== Session Create Success ==========");
			System.out.println("========== Session Info ==========");
			System.out.println("ID : " + session.getAttribute("u_uid") + ", PW : " + session.getAttribute("u_pw")
					+ ", Mode : " + session.getAttribute("u_mode"));
		} else {
			System.out.println("========== SignIn Failed ==========");
		}
		return result;
	}
}
