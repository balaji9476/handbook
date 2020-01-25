package com.pyt.handbook.request;

import javax.validation.constraints.NotBlank;

public class UserSignupRequest {
	@NotBlank
	private String empId;
	@NotBlank
	private String name;
	@NotBlank
	private String password;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
