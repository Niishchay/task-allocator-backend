package com.example.demo.entity;

import com.example.demo.enums.RequestStatus;
import com.example.demo.enums.Role;
import com.example.demo.enums.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddOn {

	private Long id;
	
	private String username;
	
	private Role role;
	
	private UserStatus status;
	
	private RequestStatus requestStatus;
}
