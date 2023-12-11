package com.spring.ex.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.spring.ex.command.GameListCommand;
import com.spring.ex.command.GameReturnCommand;
import com.spring.ex.command.GameInfoCommand;
import com.spring.ex.command.IdDupCheckCommand;
import com.spring.ex.command.Pagination;
import com.spring.ex.command.RentalInsertCommand;
import com.spring.ex.command.RentalSelectCommand;
import com.spring.ex.command.ReviewInsertCommand;
import com.spring.ex.command.ReviewSelectCommand;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring.ex.command.SignInCheckCommand;
import com.spring.ex.command.SignUpCheckCommand;
import com.spring.ex.command.UserInfoCommand;
import com.spring.ex.dao.ReviewDAO;
import com.spring.ex.dto.UserDTO;

@Controller
public class UserController {

	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private HttpSession session;

	@Autowired
	private ReviewDAO dao;
	@Autowired
	private Pagination paging;

	// Command Autowired
	@Autowired
	private SignInCheckCommand signinCheckCommand;
	@Autowired
	private IdDupCheckCommand idDupCheckCommand;
	@Autowired
	private SignUpCheckCommand signUpCheckCommand;
	@Autowired
	private GameListCommand gameListCommand;
	@Autowired
	private GameInfoCommand gameSelectCommand;
	@Autowired
	private RentalInsertCommand rentalCommand;
	@Autowired
	private UserInfoCommand userInfoCommand;
	@Autowired
	private RentalSelectCommand rentalSelectCommand;
	@Autowired
	private GameReturnCommand gameReturnCommand;
	@Autowired
	private ReviewInsertCommand reviewInsertCommand;
	@Autowired
	private ReviewSelectCommand reviewSelectCommand;

	@RequestMapping("")
	public String home() {

		return "/home";
	}

	@RequestMapping("/index")
	public String index() {

		return "/index";
	}

	@RequestMapping("/signOut")
	public String signOut() {
		session.invalidate();

		return "/index";
	}

	@RequestMapping("/signUp")
	public String signUp() {

		return "/signUp";
	}

	// Sign In Check
	@RequestMapping("/signinCheck")
	public String signinCheck(HttpServletRequest request, Model model) {
		System.out.println("========== SignIn Check: Controller ==========");
		model.addAttribute("request", request);

		int result = signinCheckCommand.execute(model);

		if (1 == result) {

			return "/index";
		} else if (3 == result) {
			request.setAttribute("msg", "승인되지 않은 아이디입니다.");
			request.setAttribute("url", "index");
		} else if (4 == result) {
			request.setAttribute("msg", "사용 정지된 아이디입니다.");
			request.setAttribute("url", "index");
		} else {
			request.setAttribute("msg", "아이디 또는 비밀번호를 확인하세요.");
			request.setAttribute("url", "index");
		}

		return "/alert";
	}

	// ID Duplicate Check
	@RequestMapping("/idCheck")
	public String idDupCheck(HttpServletRequest request) {
		System.out.println("========== ID Duplicate Checking ==========");
		String id = request.getParameter("u_id");
		System.out.println("Check ID : " + id);

		int result = idDupCheckCommand.execute(id);
		if (1 == result) {
			System.out.println("========== Duplicate ID ==========");
			request.setAttribute("msg", "중복된 아이디입니다.");
			request.setAttribute("url", "");
		} else {
			System.out.println("========== Available ID ==========");
			request.setAttribute("msg", "사용 가능한 아이디입니다.");
			request.setAttribute("url", "");
		}

		return "alert";
	}

	// Sign Up Check
	@RequestMapping("/signUpCheck")
	public String signUpCheck(HttpServletRequest request, Model model) {
		System.out.println("========== SignUp Checking ==========");
		model.addAttribute("request", request);

		int result = signUpCheckCommand.execute(model);
		if (1 == result) {
			System.out.println("========== SignUp Success ==========");
			request.setAttribute("msg", "회원가입이 완료되었습니다.");
			request.setAttribute("url", "index");
		} else if (3 == result) {
			System.out.println("========== Dupilicate ID ==========");
			request.setAttribute("msg", "중복된 아이디입니다.");
			request.setAttribute("url", "signUp");
		} else {
			System.out.println("========== SignUp Failed ==========");
			request.setAttribute("msg", "회원가입에 실패하였습니다");
			request.setAttribute("url", "signUp");
		}
		return "/alert";
	}

	// Product List Page
	@RequestMapping("/productPage")
	public ModelAndView productPage(Model model) {
		System.out.println("========== Product Page Loading ==========");
		gameListCommand.execute(model);

		ModelAndView mv = new ModelAndView("productPage");
		mv.addObject("data", gameListCommand.execute(model));

		return mv;
	}

	// Product Detail Page
	@RequestMapping("/productDetail")
	public ModelAndView productDetail(HttpServletRequest request,
			@RequestParam(value = "page", required = false, defaultValue = "1") int curPage, Model model) {
		System.out.println("========== Product Detail Page ==========");
		String g_id = request.getParameter("g_id");
		System.out.println("GID : " + g_id);

		paging.makeBlock(curPage);

		int startNum = paging.getStartNum();
		int lastNum = paging.getLastNum();
		int lastPageNum = paging.makeLastPageNumSelectGame(Integer.parseInt(g_id));
		System.out.println("Start Num : " + startNum + ", Last Num : " + lastNum + ", LastPage : " + lastPageNum);

		model.addAttribute("startNum", startNum);
		model.addAttribute("lastNum", lastNum);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("curPageNum", curPage);

		ModelAndView mv = new ModelAndView("productDetail");
		mv.addObject("gameData", gameSelectCommand.execute(model, g_id));
		mv.addObject("reviewData", reviewSelectCommand.execute(model, g_id));

		return mv;
	}

	@RequestMapping("/rental")
	public String rental(HttpServletRequest request, Model model) {
		System.out.println("========== Rental Page ==========");
		System.out.println(request.getParameter("g_id"));
		System.out.println(request.getParameter("g_name"));

		model.addAttribute("userName", session.getAttribute("u_name"));
		model.addAttribute("gameName", request.getParameter("g_name"));
		model.addAttribute("userId", session.getAttribute("u_id"));
		model.addAttribute("gameId", request.getParameter("g_id"));

		return "/rental";
	}

	@RequestMapping("/rentalInsert")
	public String rentalInsert(HttpServletRequest request, Model model) {
		System.out.println("========== Rental Insert ==========");
		model.addAttribute("request", request);

		int result = rentalCommand.execute(model);
		if (1 == result) {
			request.setAttribute("msg", "대여처리 되었습니다.");
			request.setAttribute("url", "close");
		} else {
			request.setAttribute("msg", "대여처리에 실패하였습니다.");
			request.setAttribute("url", "close");
		}

		return "/alert";
	}

	@RequestMapping("/myPage")
	public ModelAndView myPage(HttpServletRequest request, Model model) {
		System.out.println("========== User My Page ==========");
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		System.out.println("UserID : " + u_id);

		ModelAndView mv = new ModelAndView("myPage");
		mv.addObject("userData", userInfoCommand.execute(model, u_id));
		mv.addObject("rentalData", rentalSelectCommand.execute(model, u_id));

		return mv;
	}

	@RequestMapping("/returnGameUser")
	public String returnGame(HttpServletRequest request) {
		System.out.println("========== User Return Game ==========");
		int u_id = Integer.parseInt(request.getParameter("r_uid"));
		int g_id = Integer.parseInt(request.getParameter("r_gid"));

		int result = gameReturnCommand.execute(u_id, g_id);
		if (1 == result) {
			request.setAttribute("msg", "반납처리 되었습니다.");
			request.setAttribute("url", "myPage");
		} else {
			request.setAttribute("msg", "반납처리에 실패하였습니다.");
			request.setAttribute("url", "myPage");
		}

		return "/alert";
	}

	@RequestMapping("/insertReview")
	public String insertReview(HttpServletRequest request) {
		System.out.println("========== Insert Review ==========");

		int result = reviewInsertCommand.execute(request);
		if (1 == result) {
			request.setAttribute("msg", "댓글 작성이 완료되었습니다.");
			request.setAttribute("url", "productDetail?g_id=" + request.getParameter("r_gid"));
		} else {
			request.setAttribute("msg", "댓글 작성에 실패하였습니다.");
			request.setAttribute("url", "productDetail?g_id=" + request.getParameter("r_gid"));
		}

		return "/alert";
	}
}
