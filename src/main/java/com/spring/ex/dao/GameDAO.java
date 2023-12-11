package com.spring.ex.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ex.dto.GameDTO;

@Service
public class GameDAO {

	@Autowired
	private SqlSession sqlSession;

	// Game List
	public List<GameDTO> gameList() {
		System.out.println("========== Game List : GameDAO ==========");

		return sqlSession.selectList("GameMapper.gameList");
	}

	// Select Game
	public List<GameDTO> selectGame(int g_id) {
		System.out.println("========== Select Game : GameDAO ==========");
		System.out.println("GID : " + g_id);

		return sqlSession.selectList("GameMapper.selectGame", g_id);
	}

	// Update Game
	public int updateGame(int g_id, String g_name, String g_content) {
		System.out.println("========== Update Game : Game DAO ==========");
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println(g_id + ", " + g_name + ", " + g_content);

		map.put("g_id", g_id);
		map.put("g_name", g_name);
		map.put("g_content", g_content);

		return sqlSession.update("GameMapper.updateGame", map);
	}

	// Rental Game
	public int rentalGame(int g_id) {
		System.out.println("========== Rental Game : GameDAO ==========");

		return sqlSession.update("GameMapper.rentalGame", g_id);
	}

	// Return Game : Admin
	public int returnGame(int g_id) {
		System.out.println("========== Return Game : GameDAO ==========");

		return sqlSession.update("GameMapper.returnGameAdmin", g_id);
	}

	// Return Game : User
	public int returnGame(int u_id, int g_id) {
		System.out.println("========== Return Game : GameDAO ==========");

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("r_gid", g_id);
		map.put("r_uid", u_id);

		return sqlSession.update("GameMapper.returnGameUser", map);
	}

	// Insert Game
	public int insertGame(String g_name, String g_content) {
		System.out.println("========== Insert Game : GameDAO ==========");
		System.out.println("Game Name : " + g_name);
		System.out.println("Game Content : " + g_content);

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("g_name", g_name);
		map.put("g_content", g_content);

		return sqlSession.insert("GameMapper.insertGame", map);
	}

}
