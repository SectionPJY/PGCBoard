package com.spring.ex.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class ReviewDTO {

	private int r_id;
	private int r_uid;
	private int r_gid;
	private Date r_date;
	private String r_content;

	private String u_name;

	public ReviewDTO(int r_id, int r_uid, int r_gid, Timestamp r_date, String r_content, String u_name) {
		this.r_id = r_id;
		this.r_uid = r_uid;
		this.r_gid = r_gid;
		this.r_date = new Date(r_date.getTime());
		this.r_content = r_content;
		this.u_name = u_name;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public int getR_uid() {
		return r_uid;
	}

	public void setR_uid(int r_uid) {
		this.r_uid = r_uid;
	}

	public int getR_gid() {
		return r_gid;
	}

	public void setR_gid(int r_gid) {
		this.r_gid = r_gid;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

}
