package com.wzd.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Transient;

public class Letter {
	@Id
	private Integer id;
	// 送达文件名
	private String title;
	// 送达目标
	private String target;
	// 证件号码
	private String idCard;
	// 手机
	private String phone;
	// 验证码
	private String code;
	// 送达时间
	private Date sendTime;
	// 签收时间
	private Date receiveTime;
	// 审理时间
	private Date trialTime;
	// 附件信息
	@Transient
	private List<File> files;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target == null ? null : target.trim();
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard == null ? null : idCard.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	public Date getTrialTime() {
		return trialTime;
	}

	public void setTrialTime(Date trialTime) {
		this.trialTime = trialTime;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

}