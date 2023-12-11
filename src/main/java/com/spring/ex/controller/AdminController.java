package com.spring.ex.controller;

import com.spring.ex.command.GameListCommand;
import com.spring.ex.command.GameReturnCommand;
import com.spring.ex.command.GameUpdateCommand;
import com.spring.ex.command.Pagination;
import com.spring.ex.command.RentalListCommand;
import com.spring.ex.command.ReviewDeleteCommand;
import com.spring.ex.command.ReviewListCommand;
import com.spring.ex.command.GameInfoCommand;
import com.spring.ex.command.GameInsertCommand;
import com.spring.ex.command.UserApprovalCommand;
import com.spring.ex.command.UserInfoCommand;
import com.spring.ex.command.UserListCommand;
import com.spring.ex.command.UserRejectionCommand;
import com.spring.ex.command.UserUpdateCommand;
import com.spring.ex.dto.GameDTO;
import com.spring.ex.dto.UserDTO;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	private UserListCommand userListCommand;
	@Autowired
	private UserRejectionCommand userRejCommand;
	@Autowired
	private UserApprovalCommand userAppCommand;
	@Autowired
	private UserInfoCommand userInfoCommand;
	@Autowired
	private UserUpdateCommand userUpdateCommand;
	@Autowired
	private GameListCommand gameListCommand;
	@Autowired
	private GameInfoCommand gameInfoCommand;
	@Autowired
	private GameUpdateCommand gameUpdateCommand;
	@Autowired
	private GameReturnCommand gameReturnCommand;
	@Autowired
	private GameInsertCommand gameInsertCommand;
	@Autowired
	private RentalListCommand rentalListCommand;
	@Autowired
	private ReviewListCommand reviewListCommand;
	@Autowired
	private ReviewDeleteCommand reviewDeleteCommand;
	@Autowired
	private Pagination paging;

//	@RequestMapping("/admin")
//	public ModelAndView admin(Model model) {
//		System.out.println("========== Admin Page Loading ==========");
//		userListCommand.execute(model);
//
//		ModelAndView mv = new ModelAndView("admin");
//		mv.addObject("data", userListCommand.execute(model));
//
//		return mv;
//	}
	@RequestMapping("/close")
	public String close() {

		return "/close";
	}

	@RequestMapping("/admin")
	public String admin() {

		return "/admin";
	}

	@RequestMapping("/userAccept")
	public String userAccept(HttpServletRequest request) {
		System.out.println("========== User Accept ==========");
		String u_id = request.getParameter("u_id");
		System.out.println("ID : " + u_id);

		int result = userAppCommand.execute(u_id);
		if (1 == result) {
			request.setAttribute("msg", "승인되었습니다.");
			request.setAttribute("url", "userList");
		} else {
			request.setAttribute("msg", "승인에 실패하였습니다.");
			request.setAttribute("url", "userList");
		}

		return "/alert";
	}

	@RequestMapping("/userRej")
	public String userRej(HttpServletRequest request) {
		System.out.println("========== User Rejection ==========");
		String id = request.getParameter("u_uid");
		System.out.println("ID : " + id);

		int result = userRejCommand.execute(id);
		if (1 == result) {
			request.setAttribute("msg", "삭제조치 되었습니다.");
			request.setAttribute("url", "userList");
		} else {
			request.setAttribute("msg", "삭제조치에 실패하였습니다.");
			request.setAttribute("url", "userList");
		}

		return "/alert";
	}

	@RequestMapping("/userInfo")
	public ModelAndView userInfo(HttpServletRequest request, Model model) {
		System.out.println("========== User Info ==========");
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		System.out.println("ID : " + u_id);

		List<UserDTO> dto = userInfoCommand.execute(model, u_id);
		if (dto.isEmpty()) {
			System.out.println("========== Failed ==========");

			ModelAndView mv = new ModelAndView("alert");
			request.setAttribute("msg", "정보를 불러오지 못했습니다.");
			request.setAttribute("url", "userList");

			return mv;
		} else {
			System.out.println("========== Success ==========");

			ModelAndView mv = new ModelAndView("userInfo");
			mv.addObject("data", dto);

			return mv;
		}
	}

	@RequestMapping("/updateUser")
	public String updateUser(HttpServletRequest request, Model model) {
		System.out.println("========== Update User Info ==========");
		model.addAttribute("request", request);

		int result = userUpdateCommand.execute(model);
		if (1 == result) {
			request.setAttribute("msg", "수정이 완료되었습니다.");
			request.setAttribute("url", "close");
		} else {
			request.setAttribute("msg", "수정에 실패하였습니다.");
			request.setAttribute("url", "userList");
		}

		return "/alert";
	}

	@RequestMapping("/uesrList")
	public ModelAndView userList(@RequestParam(value = "page", required = false, defaultValue = "1") int curPage,
			Model model) {
		System.out.println("========== User List Page ==========");

		paging.makeBlock(curPage);

		int startNum = paging.getStartNum();
		int lastNum = paging.getLastNum();
		int lastPageNumUser = paging.makeLastPageNumUser();
		int lastPageNumUserRej = paging.makeLastPageNumUserRej();
		int lastPageNumUserUn = paging.makeLastPageNumUserUn();
		System.out.println("Start Num : " + startNum + ", Last Num : " + lastNum);

		model.addAttribute("startNum", startNum);
		model.addAttribute("lastNum", lastNum);
		model.addAttribute("lastPageNumUser", lastPageNumUser);
		model.addAttribute("lastPageNumUserRej", lastPageNumUserRej);
		model.addAttribute("lastPageNumUserUn", lastPageNumUserUn);
		model.addAttribute("curPageNum", curPage);

		ModelAndView mv = new ModelAndView("userList");
		mv.addObject("data", userListCommand.execute(model));

		return mv;
	}

	@RequestMapping("/gameList")
	public ModelAndView gameList(Model model) {
		System.out.println("========== Game List Page ==========");
		ModelAndView mv = new ModelAndView("gameList");

		mv.addObject("data", gameListCommand.execute(model));

		return mv;
	}

	@RequestMapping("/gameInfo")
	public ModelAndView gameInfo(HttpServletRequest request, Model model) {
		System.out.println("========== Game Info ==========");
		String g_id = request.getParameter("g_id");
		System.out.println("ID : " + g_id);

		List<GameDTO> dto = gameInfoCommand.execute(model, g_id);
		if (dto.isEmpty()) {
			System.out.println("========== Failed ==========");

			ModelAndView mv = new ModelAndView("alert");
			request.setAttribute("msg", "정보를 불러오지 못했습니다.");
			request.setAttribute("url", "gameList");

			return mv;
		} else {
			System.out.println("========== Success ==========");

			ModelAndView mv = new ModelAndView("gameInfo");
			mv.addObject("data", dto);

			return mv;
		}
	}

	@RequestMapping("/updateGame")
	public String updateGame(HttpServletRequest request, Model model) {
		System.out.println("========== Update Game Info ==========");
		model.addAttribute("request", request);

		int result = gameUpdateCommand.execute(model);
		if (1 == result) {
			request.setAttribute("msg", "수정이 완료되었습니다.");
			request.setAttribute("url", "close");
		} else {
			request.setAttribute("msg", "수정에 실패하였습니다.");
			request.setAttribute("url", "close");
		}

		return "/alert";
	}

	@RequestMapping("/gameRegister")
	public String gameRegister() {
		System.out.println("========== Game Register Page ==========");

		return "/gameRegister";
	}

	@RequestMapping("/gameInsert")
	public String gameInsert(MultipartHttpServletRequest request) {
		System.out.println("========== Game Insert ==========");

		int result = gameInsertCommand.execute(request);
		if (1 == result) {
			request.setAttribute("msg", "등록에 성공하였습니다.");
			request.setAttribute("url", "gameList");
		} else {
			request.setAttribute("msg", "등록에 실패하였습니다.");
			request.setAttribute("url", "gameList");
		}

		return "/alert";
	}

	@RequestMapping("/gameReturn")
	public String gameReturn(HttpServletRequest request, Model model) {
		System.out.println("========== Game Return ==========");
		model.addAttribute("request", request);

		int result = gameReturnCommand.execute(model);
		if (1 == result) {
			request.setAttribute("msg", "반납처리가 완료되었습니다.");
			request.setAttribute("url", "close");
		} else {
			request.setAttribute("msg", "반납처리에 실패하였습니다.");
			request.setAttribute("url", "close");
		}

		return "/alert";
	}

	@RequestMapping("/rentalList")
	public ModelAndView rentalList(@RequestParam(value = "page", required = false, defaultValue = "1") int curPage,
			Model model) {
		System.out.println("========== Rental List ==========");
		paging.makeBlock(curPage);

		int startNum = paging.getStartNum();
		int lastNum = paging.getLastNum();
		int lastPageNumRental = paging.makeLastPageNumRental();
		int lastPageNumReturn = paging.makeLastPageNumReturn();
		System.out.println("Start Num : " + startNum + ", Last Num : " + lastNum);

		model.addAttribute("startNum", startNum);
		model.addAttribute("lastNum", lastNum);
		model.addAttribute("lastPageNumRental", lastPageNumRental);
		model.addAttribute("lastPageNumReturn", lastPageNumReturn);
		model.addAttribute("curPageNum", curPage);

		int offset = (curPage - 1) * 10 + 1;
		ModelAndView mv = new ModelAndView("rentalList");
		mv.addObject("data", rentalListCommand.execute(model, offset));

		return mv;
	}

	@RequestMapping("/reviewList")
	public ModelAndView reviewList(@RequestParam(value = "page", required = false, defaultValue = "1") int curPage,
			Model model) {
		System.out.println("========== Review List ==========");
		paging.makeBlock(curPage);

		int startNum = paging.getStartNum();
		int lastNum = paging.getLastNum();
		int lastPageNum = paging.makeLastPageNumReview();
		System.out.println("Start Num : " + startNum + ", Last Num : " + lastNum + ", LastPage : " + lastPageNum);

		model.addAttribute("startNum", startNum);
		model.addAttribute("lastNum", lastNum);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("curPageNum", curPage);

		int offset = (curPage - 1) * 10 + 1;
		ModelAndView mv = new ModelAndView("reviewList");
		mv.addObject("data", reviewListCommand.execute(model, offset));

		return mv;
	}

	@RequestMapping("/reviewDelete")
	public String reviewDelete(HttpServletRequest request) {
		System.out.println("========== Review Delete ==========");

		int r_id = Integer.parseInt(request.getParameter("r_id"));
		System.out.println("RID : " + r_id);

		int result = reviewDeleteCommand.execute(r_id);
		if (1 == result) {
			request.setAttribute("msg", "삭제되었습니다.");
			request.setAttribute("url", "reviewList?page=1");
		} else {
			request.setAttribute("msg", "삭제에 실패하였습니다.");
			request.setAttribute("url", "reviewList?page=1");
		}

		return "/alert";
	}
}
