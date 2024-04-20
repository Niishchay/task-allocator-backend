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

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
