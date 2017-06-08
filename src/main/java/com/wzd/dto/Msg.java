package com.wzd.dto;

import com.alibaba.fastjson.JSON;

public class Msg {
	private Integer code;
	private String msg;

	public Msg() {
		super();
	}

	public Msg(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static Msg success(String msg) {
		return new Msg(200, msg);
	}

	public static Msg error(String msg) {
		return new Msg(500, msg);
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
