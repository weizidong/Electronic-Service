package com.wzd.entity;

import javax.persistence.Id;

import com.alibaba.fastjson.JSON;

public class User {
	@Id
	private Integer id;

	private String name;

	private Integer type;

	private String userid;

	private String pwd;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid == null ? null : userid.trim();
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd == null ? null : pwd.trim();
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}