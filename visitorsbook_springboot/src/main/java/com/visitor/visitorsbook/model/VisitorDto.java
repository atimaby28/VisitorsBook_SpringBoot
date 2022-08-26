package com.visitor.visitorsbook.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "VisitorDto (회원정보)", description = "아이디, 비번, 이름.을 가진   Domain Class")
public class VisitorDto {

	@ApiModelProperty(value = "회원이름")
	private String visitorName;
	@ApiModelProperty(value = "회원아이디")
	private String visitorId;
	@ApiModelProperty(value = "회원비밀번호")
	private String visitorPwd;
	@ApiModelProperty(value = "이메일")
	private String email;
	@ApiModelProperty(value = "가입일")
	private String joinDate;

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(String visitorId) {
		this.visitorId = visitorId;
	}

	public String getVisitorPwd() {
		return visitorPwd;
	}

	public void setVisitorPwd(String visitorPwd) {
		this.visitorPwd = visitorPwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "VisitorDto [visitorName=" + visitorName + ", visitorId=" + visitorId + ", visitorPwd=" + visitorPwd + ", email=" + email
				+ ", joinDate=" + joinDate + "]";
	}

}
