package com.example.demo.entity;

import com.example.demo.enums.Priority;
import com.example.demo.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Title is mandatory field")
	@Column(nullable = false)
	private String title;
	
	@NotNull(message = "Priority is mandatory field")
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Priority priority;
	
	@NotNull(message = "Status is mandatory field")
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "assigned_to")
	private Long assignedTo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Long assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Task(Long id, @NotNull(message = "Title is mandatory field") String title,
			@NotNull(message = "Priority is mandatory field") Priority priority,
			@NotNull(message = "Status is mandatory field") Status status, Long assignedTo) {
		super();
		this.id = id;
		this.title = title;
		this.priority = priority;
		this.status = status;
		this.assignedTo = assignedTo;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
