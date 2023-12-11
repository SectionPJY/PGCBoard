package com.spring.ex.dto;

public class UserDTO {

	private int u_id;
	private String u_uid;
	private String u_pw;
	private String u_name;
	private int u_age;
	private String u_phone;
	private int u_mode;
	private int u_reg;

	public UserDTO(int u_id, String u_uid, String u_pw, String u_name, int u_age, String u_phone, int u_mode,
			int u_reg) {
		this.u_id = u_id;
		this.u_uid = u_uid;
		this.u_pw = u_pw;
		this.u_name = u_name;
		this.u_age = u_age;
		this.u_phone = u_phone;
		this.u_mode = u_mode;
		this.u_reg = u_reg;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getU_uid() {
		return u_uid;
	}

	public void setU_uid(String u_uid) {
		this.u_uid = u_uid;
	}

	public String getU_pw() {
		return u_pw;
	}

	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public int getU_age() {
		return u_age;
	}

	public void setU_age(int u_age) {
		this.u_age = u_age;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public int getU_mode() {
		return u_mode;
	}

	public void setU_mode(int u_mode) {
		this.u_mode = u_mode;
	}

	public int getU_reg() {
		return u_reg;
	}

	public void setU_reg(int u_reg) {
		this.u_reg = u_reg;
	}

}
