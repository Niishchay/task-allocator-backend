package com.example.demo.entity;

import java.time.LocalDateTime;

import com.example.demo.enums.RequestStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
