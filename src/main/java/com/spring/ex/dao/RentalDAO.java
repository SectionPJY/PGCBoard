package com.spring.ex.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ex.dto.RentalDTO;

@Service
public class RentalDAO {

	@Autowired
	private SqlSession sqlSession;

	// Insert Rental
	public int insertRental(int r_uid, int r_gid, String r_purpose) {
		System.out.println("========== Insert Rental : RentalDAO ==========");
		System.out.println("UserID: " + r_uid + ", GameID: " + r_gid + ", Content: " + r_purpose);

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("r_uid", r_uid);
		map.put("r_gid", r_gid);
		map.put("r_purpose", r_purpose);

		return sqlSession.insert("RentalMapper.insertRental", map);
	}

	// Select Rental
	public List<RentalDTO> selectRental(int u_id) {
		System.out.println("========== Select Rental ==========");
		System.out.println("UserID : " + u_id);

		return sqlSession.selectList("RentalMapper.selectRental", u_id);
	}

	// Rental List
	public List<RentalDTO> rentalList(int offset) {
		System.out.println("========== Rental List : RentalDAO ==========");

		return sqlSession.selectList("RentalMapper.rentalList", offset);
	}

	// Return List
	public List<RentalDTO> returnList(int offset) {
		System.out.println("========== Return List : RentalDAO ==========");

		return sqlSession.selectList("RentalMapper.returnList", offset);
	}

	// Rental Count
	public int retalCnt() {
		System.out.println("========== Rental Count : RentalDAO ==========");

		return sqlSession.selectOne("RentalMapper.rentalCnt");
	}

	// Return Count
	public int returnCnt() {
		System.out.println("========== Return Count : RentalDAO ==========");

		return sqlSession.selectOne("RentalMapper.returnCnt");
	}

}
