package com.example.demo.entity;

import com.example.demo.enums.RequestStatus;
import com.example.demo.enums.Role;
import com.example.demo.enums.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserAddOn {

	private Long id;
	
	private String username;
	
	private Role role;
	
	private UserStatus status;
	
	private RequestStatus requestStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public RequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

	public UserAddOn(Long id, String username, Role role, UserStatus status, RequestStatus requestStatus) {
		super();
		this.id = id;
		this.username = username;
		this.role = role;
		this.status = status;
		this.requestStatus = requestStatus;
	}

	public UserAddOn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
