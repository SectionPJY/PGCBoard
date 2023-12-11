package com.spring.ex.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ex.dao.RentalDAO;
import com.spring.ex.dao.ReviewDAO;
import com.spring.ex.dao.UserDAO;

@Service
public class Pagination {

	@Autowired
	private ReviewDAO daoReview;
	@Autowired
	private RentalDAO daoRental;
	@Autowired
	private UserDAO daoUser;

	private final static int PAGE_COUNT = 10;
	private int startNum;
	private int lastNum;
	private int lastPageNum;
	private int curPage;

	public void makeBlock(int curPage) {
		System.out.println("========== Make Block : " + curPage + " ==========");
		int blockNum = 0;

		blockNum = (int) Math.floor((curPage - 1) / PAGE_COUNT);
		startNum = (PAGE_COUNT * blockNum) + 1;
		lastNum = startNum + (PAGE_COUNT - 1);

		System.out.println("BlockNum : " + blockNum);
	}

	public int makeLastPageNumReview() {
		int total = daoReview.reviewTotalCnt();
		System.out.println("Review Total : " + total);
		if (total % PAGE_COUNT == 0)
			return lastPageNum = (int) Math.floor(total / PAGE_COUNT);
		else
			return lastPageNum = (int) Math.floor(total / PAGE_COUNT) + 1;
	}

	public int makeLastPageNumRental() {
		int total = daoRental.retalCnt();
		System.out.println("Review Total : " + total);
		if (total % PAGE_COUNT == 0)
			return lastPageNum = (int) Math.floor(total / PAGE_COUNT);
		else
			return lastPageNum = (int) Math.floor(total / PAGE_COUNT) + 1;
	}

	public int makeLastPageNumReturn() {
		int total = daoRental.returnCnt();
		System.out.println("Review Total : " + total);
		if (total % PAGE_COUNT == 0)
			return lastPageNum = (int) Math.floor(total / PAGE_COUNT);
		else
			return lastPageNum = (int) Math.floor(total / PAGE_COUNT) + 1;
	}
	
	public int makeLastPageNumUser() {
		int total = daoUser.userCnt();
		System.out.println("Review Total : " + total);
		if (total % PAGE_COUNT == 0)
			return lastPageNum = (int) Math.floor(total / PAGE_COUNT);
		else
			return lastPageNum = (int) Math.floor(total / PAGE_COUNT) + 1;
	}
	
	public int makeLastPageNumUserRej() {
		int total = daoUser.userCntRej();
		System.out.println("Review Total : " + total);
		if (total % PAGE_COUNT == 0)
			return lastPageNum = (int) Math.floor(total / PAGE_COUNT);
		else
			return lastPageNum = (int) Math.floor(total / PAGE_COUNT) + 1;
	}
	
	public int makeLastPageNumUserUn() {
		int total = daoUser.userCntUn();
		System.out.println("Review Total : " + total);
		if (total % PAGE_COUNT == 0)
			return lastPageNum = (int) Math.floor(total / PAGE_COUNT);
		else
			return lastPageNum = (int) Math.floor(total / PAGE_COUNT) + 1;
	}
	
	public int makeLastPageNumSelectGame(int r_gid) {
		int total = daoReview.reviewSelectCnt(r_gid);
		System.out.println("Review Total : " + total);
		if (total % PAGE_COUNT == 0)
			return lastPageNum = (int) Math.floor(total / PAGE_COUNT);
		else
			return lastPageNum = (int) Math.floor(total / PAGE_COUNT) + 1;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getLastNum() {
		return lastNum;
	}

	public void setLastNum(int lastNum) {
		this.lastNum = lastNum;
	}

	public int getLastPageNum() {
		return lastPageNum;
	}

	public void setLastPageNum(int lastPageNum) {
		this.lastPageNum = lastPageNum;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

}
