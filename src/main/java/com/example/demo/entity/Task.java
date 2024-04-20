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

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
