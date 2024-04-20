package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Task;
import com.example.demo.entity.TaskRequest;
import com.example.demo.enums.Status;
import com.example.demo.service.TaskService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api/task/")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping("create-task")
	public ResponseEntity<Task> Task (@Valid @RequestBody Task task) {
		return ResponseEntity.ok(taskService.createTask(task));
	}
	
	@GetMapping("get-task/{assignedToId}")
	public ResponseEntity<List<Task>> getAllTaskByAssignedToId(@PathVariable Long assignedToId) {
		return ResponseEntity.ok(taskService.getAllTaskByAssignedToId(assignedToId));
	}
	
	@GetMapping("get-task")
	public ResponseEntity<List<Task>> getAllTaskByAssignedToId() {
		return ResponseEntity.ok(taskService.getAllTask());
	}
	
	@PutMapping("assign-user/{taskId}")
	public ResponseEntity<Task> assignUserToTaskById(@PathVariable Long taskId, @RequestParam Long userId) {
		return ResponseEntity.ok(taskService.assignUserToTaskById(userId, taskId));
	}
	
	@PutMapping("assign-task/{taskRequestId}")
	public ResponseEntity<TaskRequest> assignTaskToUserById(@PathVariable Long taskRequestId, @RequestParam Long taskId) {
		return ResponseEntity.ok(taskService.assignTaskToUserById(taskRequestId, taskId));
	}
	
	@GetMapping("get-task-assigned")
	public ResponseEntity<List<Task>> getTaskToBeAssigned() {
		return ResponseEntity.ok(taskService.getTaskToBeAssigned());
	}
	
	@PutMapping("update-task-status/{id}")
	public ResponseEntity<Void> taskStatusUpdate(@PathVariable Long id, @Valid @RequestParam Status status){
		taskService.taskStatusUpdate(id, status);
		return ResponseEntity.ok().build();
	}
}
