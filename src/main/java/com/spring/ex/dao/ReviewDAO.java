package com.spring.ex.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ex.dto.ReviewDTO;

@Service
public class ReviewDAO {

	@Autowired
	private SqlSession sqlSession;

	// Review List
	public List<ReviewDTO> reviewList(int startNum) {
		System.out.println("========== Review List ==========");
		System.out.println("시작번호 : " + startNum);

		return sqlSession.selectList("ReviewMapper.reviewList", startNum);
	}

	// Insert Review
	public int insertReview(int r_uid, int r_gid, String r_content) {
		System.out.println("========== Insert Review DAO ==========");

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("r_uid", r_uid);
		map.put("r_gid", r_gid);
		map.put("r_content", r_content);

		return sqlSession.insert("ReviewMapper.insertReview", map);
	}

	// Select Review List
	public List<ReviewDTO> selectReview(int g_id) {
		System.out.println("========== Select Review DAO ==========");
		System.out.println("GID : " + g_id);

		return sqlSession.selectList("ReviewMapper.selectReview", g_id);
	}

	// Review Total Count
	public int reviewTotalCnt() {
		System.out.println("========== Review Total Count DAO ==========");

		return sqlSession.selectOne("ReviewMapper.reviewTotalCnt");
	}
	
	// Review Select Count
	public int reviewSelectCnt(int r_gid) {
		System.out.println("========== Review Select Count DAO ==========");
		
		return sqlSession.selectOne("ReviewMapper.reviewSelectCnt");
	}

	// Review Delete
	public int reviewDelete(int r_id) {
		System.out.println("========== Review Delete DAO ==========");

		return sqlSession.delete("ReviewMapper.reviewDelete", r_id);
	}
}
