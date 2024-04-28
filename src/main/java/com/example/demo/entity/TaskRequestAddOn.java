package com.example.demo.entity;

import java.time.LocalDateTime;

import com.example.demo.enums.RequestStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class TaskRequestAddOn {
	
	private Long id;
	
	private Long requesterId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String requesterUsername;
	
	private Long assigneeId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String assigneeUsername;
	
	private Long taskId;

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

	public String getRequesterUsername() {
		return requesterUsername;
	}

	public void setRequesterUsername(String requesterUsername) {
		this.requesterUsername = requesterUsername;
	}

	public Long getAssigneeId() {
		return assigneeId;
	}

	public void setAssigneeId(Long assigneeId) {
		this.assigneeId = assigneeId;
	}

	public String getAssigneeUsername() {
		return assigneeUsername;
	}

	public void setAssigneeUsername(String assigneeUsername) {
		this.assigneeUsername = assigneeUsername;
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

	public TaskRequestAddOn(Long id, Long requesterId, String requesterUsername, Long assigneeId,
			String assigneeUsername, Long taskId, RequestStatus requestStatus, LocalDateTime requestDate) {
		super();
		this.id = id;
		this.requesterId = requesterId;
		this.requesterUsername = requesterUsername;
		this.assigneeId = assigneeId;
		this.assigneeUsername = assigneeUsername;
		this.taskId = taskId;
		this.requestStatus = requestStatus;
		this.requestDate = requestDate;
	}

	public TaskRequestAddOn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
