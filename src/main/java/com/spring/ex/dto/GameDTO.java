package com.spring.ex.dto;

public class GameDTO {

	private int g_id;
	private String g_name;
	private String g_content;
	private int g_rent;

	public GameDTO(int g_id, String g_name, String g_content, int g_rent) {
		this.g_id = g_id;
		this.g_name = g_name;
		this.g_content = g_content;
		this.g_rent = g_rent;
	}

	public int getG_id() {
		return g_id;
	}

	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public String getG_content() {
		return g_content;
	}

	public void setG_content(String g_content) {
		this.g_content = g_content;
	}

	public int getG_rent() {
		return g_rent;
	}

	public void setG_rent(int g_rent) {
		this.g_rent = g_rent;
	}

}
