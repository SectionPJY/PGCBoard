package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.ex.dao.RentalDAO;

@Service
public class RentalInsertCommand {

	@Autowired
	private RentalDAO dao;
	@Autowired
	private GameRentalCommand gameRentalCommand;

	public int execute(Model model) {
		System.out.println("========== Rental Insert Command Running ==========");
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int r_uid = Integer.parseInt(request.getParameter("r_uid"));
		int r_gid = Integer.parseInt(request.getParameter("r_gid"));
		String r_purpose = request.getParameter("r_content");

		int insertResult = dao.insertRental(r_uid, r_gid, r_purpose);
		int updateResult = gameRentalCommand.execute(r_gid);
		if (1 == insertResult && 1 == updateResult) {
			System.out.println("========== Insert Success ==========");

			return 1;
		} else {
			System.out.println("========== Insert Failed ==========");

			return 0;
		}
	}
}
