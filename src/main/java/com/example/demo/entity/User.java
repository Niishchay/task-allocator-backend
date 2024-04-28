package com.example.demo.entity;

import com.example.demo.enums.Role;
import com.example.demo.enums.UserStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "username is mandatory field")
	@Size(min = 4, max = 12, message= "username should be between 4-12 characters")
	@Column(unique = true, nullable = false)
	private String username;
	
	@NotNull(message = "password is mandatory field")
	@Size(min = 4, max = 8, message= "password should be between 4-8 characters")
	@Column(nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Enumerated(EnumType.STRING)
	private UserStatus status;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public User(Long id,
			@NotNull(message = "username is mandatory field") @Size(min = 4, max = 12, message = "username should be between 4-12 characters") String username,
			@NotNull(message = "password is mandatory field") @Size(min = 4, max = 8, message = "password should be between 4-8 characters") String password,
			Role role, UserStatus status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.status = status;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
