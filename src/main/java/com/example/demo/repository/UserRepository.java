package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;
import com.example.demo.enums.Role;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public User getByUsername(String username);
	public List<User> getByRole(Role role);
	public List<User> findByRoleNot(Role role);
}
