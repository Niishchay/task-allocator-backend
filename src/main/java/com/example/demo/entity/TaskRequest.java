package com.example.demo.entity;

import java.time.LocalDateTime;

import com.example.demo.enums.RequestStatus;

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
public class TaskRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Long requesterId;
	
	@NotNull
	private Long assigneeId;
	
	private Long taskId;

	@Enumerated(EnumType.STRING)
	private RequestStatus requestStatus;
	
	private LocalDateTime requestDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRequesterId() {
		return requesterId;
	}

	public void setRequesterId(Long requesterId) {
		this.requesterId = requesterId;
	}

	public Long getAssigneeId() {
		return assigneeId;
	}

	public void setAssigneeId(Long assigneeId) {
		this.assigneeId = assigneeId;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public RequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

	public LocalDateTime getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(LocalDateTime requestDate) {
		this.requestDate = requestDate;
	}

	public TaskRequest(Long id, @NotNull Long requesterId, @NotNull Long assigneeId, Long taskId,
			RequestStatus requestStatus, LocalDateTime requestDate) {
		super();
		this.id = id;
		this.requesterId = requesterId;
		this.assigneeId = assigneeId;
		this.taskId = taskId;
		this.requestStatus = requestStatus;
		this.requestDate = requestDate;
	}

	public TaskRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
