package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TaskRequest;
import com.example.demo.entity.TaskRequestAddOn;
import com.example.demo.service.TaskRequestService;

import jakarta.validation.Valid;


@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api/task-request/")
public class TaskRequestController {
	
	@Autowired
	TaskRequestService taskRequestService;
	
	@PostMapping("create-task-request")
	public ResponseEntity<TaskRequest> createTaskRequest(@Valid @RequestBody TaskRequest taskRequest) {
		return ResponseEntity.ok(taskRequestService.createTaskRequest(taskRequest));
	}
	
	@GetMapping("requester-task-list/{id}")
	public ResponseEntity<List<TaskRequestAddOn>> getTaskListByRequesterId(@PathVariable Long id) {
		return ResponseEntity.ok(taskRequestService.getTaskRequestListByRequesterId(id));
	}
	
	@GetMapping("assignee-task-list/{id}")
	public ResponseEntity<List<TaskRequestAddOn>> getTaskListByAssigneeId(@PathVariable Long id) {
		return ResponseEntity.ok(taskRequestService.getTaskRequestListByAssigneeId(id));
	}
	
	@PutMapping("undo-task-request/{id}")
	public ResponseEntity<Boolean> undoTaskReuqest(@PathVariable Long id) {
		taskRequestService.undoTaskReuqest(id);
		return ResponseEntity.ok(true);
	}
	
}
