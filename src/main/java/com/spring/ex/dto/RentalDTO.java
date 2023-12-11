package com.spring.ex.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class RentalDTO {

	private int r_id;
	private int r_uid;
	private int r_gid;
	private Date r_date;
	private String r_purpose;
	private int r_return;
	private Date r_rdate;

	private String g_name;
	private String u_name;

	public RentalDTO(int r_id, int r_uid, int r_gid, Timestamp r_date, String r_purpose, int r_return, Timestamp r_rdate, String g_name) {
		this.r_id = r_id;
		this.r_uid = r_uid;
		this.r_gid = r_gid;
		this.r_date = new Date(r_date.getTime());
		this.r_purpose = r_purpose;
		this.r_return = r_return;
		this.r_rdate = new Date(r_rdate.getTime());
		this.g_name = g_name;
	}

	public RentalDTO(int r_id, int r_uid, int r_gid, Timestamp r_date, String r_purpose, int r_return, Timestamp r_rdate, String g_name,
			String u_name) {
		this.r_id = r_id;
		this.r_uid = r_uid;
		this.r_gid = r_gid;
		this.r_date = new Date(r_date.getTime());
		this.r_purpose = r_purpose;
		this.r_return = r_return;
		this.r_rdate = new Date(r_rdate.getTime());
		this.g_name = g_name;
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

	public String getR_purpose() {
		return r_purpose;
	}

	public void setR_purpose(String r_purpose) {
		this.r_purpose = r_purpose;
	}

	public int getr_return() {
		return r_return;
	}

	public void setr_return(int r_return) {
		this.r_return = r_return;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public Date getR_rdate() {
		return r_rdate;
	}

	public void setR_rdate(Date r_rdate) {
		this.r_rdate = r_rdate;
	}

}
