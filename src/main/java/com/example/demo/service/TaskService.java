package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Task;
import com.example.demo.entity.TaskRequest;
import com.example.demo.entity.User;
import com.example.demo.enums.RequestStatus;
import com.example.demo.enums.Status;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.TaskRequestRepository;
import com.example.demo.repository.UserRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TaskRequestRepository taskRequestRepository;
	
	public User checkIfUserExist(Long id) {
		return userRepository.findById(id).orElseThrow(()-> new RuntimeException("Assigned user not found"));
	}
	
	public Task checkIfTaskExist(Long id) {
		return taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found"));
	}
	
	public TaskRequest checkIfTaskRequestExist(Long id) {
		return taskRequestRepository.findById(id).orElseThrow(()-> new RuntimeException("Task request not found"));
	}
	
	public Task createTask(Task task) {
		if(task.getAssignedTo() != null) {
			checkIfUserExist(task.getAssignedTo());
		}
		return taskRepository.save(task);
	}
	
	public List<Task> getAllTaskByAssignedToId(Long assignedToId) {
		return taskRepository.findByAssignedTo(assignedToId);
	}
	
	public List<Task> getAllTask() {
		return taskRepository.findAll();
	}
	
	public Task assignUserToTaskById(Long userId, Long taskId) {
		Task task = checkIfTaskExist(taskId);
		task.setAssignedTo(userId);
		task.setStatus(Status.ASSIGNED);
		taskRepository.save(task);
		return task;
	}
	
	public TaskRequest assignTaskToUserById(Long taskRequestId, Long taskId) {
		TaskRequest taskRequest = checkIfTaskRequestExist(taskRequestId);
		Task task = checkIfTaskExist(taskId);
		task.setAssignedTo(taskRequest.getRequesterId());
		task.setStatus(Status.ASSIGNED);
		taskRequest.setRequestStatus(RequestStatus.APPROVED);
		taskRepository.save(task);
		taskRequest.setTaskId(taskId);
		return taskRequestRepository.save(taskRequest);
	}
	
	public List<Task> getTaskToBeAssigned(){
		List<Task> tasks = taskRepository.findByAssignedToIsNull();
		if(tasks != null) {
			return tasks;
		}
		throw new RuntimeException("Tasks not found");
	}
	
	public void taskStatusUpdate(Long id, Status status) {
		Task task = checkIfTaskExist(id);
		task.setStatus(status);
		taskRepository.save(task);
	}
}
