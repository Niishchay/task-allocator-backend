package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
	public List<Task> findByAssignedTo(Long assignedTo);
	public List<Task> findByAssignedToIsNull();
}
