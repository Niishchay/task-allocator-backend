package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TaskRequest;
import com.example.demo.entity.TaskRequestAddOn;
import com.example.demo.entity.User;
import com.example.demo.enums.RequestStatus;
import com.example.demo.repository.TaskRequestRepository;
import com.example.demo.repository.UserRepository;

@Service
public class TaskRequestService {
	
	@Autowired
	TaskRequestRepository taskRequestRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public void checkIfUserExist(String name, Long id) {
		userRepository.findById(id).orElseThrow(()-> new RuntimeException(name + " not found " + id));
	}
	
	public void checkIfTaskRequestExist(Long assigneeId, Long requesterId) {
		TaskRequest taskRequest = taskRequestRepository.findByAssigneeIdAndRequesterIdAndRequestStatus(assigneeId, requesterId, RequestStatus.PENDING);
		if(taskRequest != null) {
			throw new RuntimeException("Task Request already exists");
		}
	}
	
	public TaskRequest createTaskRequest(TaskRequest taskRequest){
		checkIfUserExist("requesterId", taskRequest.getRequesterId());
		checkIfUserExist("assigneeId", taskRequest.getAssigneeId());
		checkIfTaskRequestExist(taskRequest.getAssigneeId(), taskRequest.getRequesterId());
		taskRequest.setRequestDate(LocalDateTime.now());
		taskRequest.setRequestStatus(RequestStatus.PENDING);
		return taskRequestRepository.save(taskRequest);
	}
	
	public List<TaskRequestAddOn> getTaskRequestListByRequesterId(Long id){
		List<TaskRequest> taskRequestList = taskRequestRepository.findByRequesterId(id);
		List<TaskRequestAddOn> taskRequestAddOnList = new ArrayList<TaskRequestAddOn>();
		for (TaskRequest taskRequest : taskRequestList) {
			User user = userRepository.findById(taskRequest.getAssigneeId()).orElseThrow(()-> new RuntimeException("User not found with id: " + id));
			TaskRequestAddOn taskRequestAddon = new TaskRequestAddOn();
			taskRequestAddon.setId(taskRequest.getId());
			taskRequestAddon.setAssigneeId(taskRequest.getAssigneeId());
			taskRequestAddon.setRequesterId(taskRequest.getRequesterId());
			taskRequestAddon.setAssigneeUsername(user.getUsername());
			taskRequestAddon.setRequestStatus(taskRequest.getRequestStatus());
			taskRequestAddon.setRequestDate(taskRequest.getRequestDate());
			taskRequestAddon.setTaskId(taskRequest.getTaskId());
			taskRequestAddOnList.add(taskRequestAddon);
		}
		return taskRequestAddOnList;
	}
	
	
	public List<TaskRequestAddOn> getTaskRequestListByAssigneeId(Long id){
		List<TaskRequest> taskRequestList = taskRequestRepository.findByAssigneeIdAndRequestStatus(id, RequestStatus.PENDING);
		List<TaskRequestAddOn> taskRequestAddOnList = new ArrayList<TaskRequestAddOn>();
		for (TaskRequest taskRequest : taskRequestList) {
			User user = userRepository.findById(taskRequest.getRequesterId()).orElseThrow(()-> new RuntimeException("User not found with id: " + id));
			TaskRequestAddOn taskRequestAddon = new TaskRequestAddOn();
			taskRequestAddon.setId(taskRequest.getId());
			taskRequestAddon.setAssigneeId(taskRequest.getAssigneeId());
			taskRequestAddon.setRequesterId(taskRequest.getRequesterId());
			taskRequestAddon.setRequesterUsername(user.getUsername());
			taskRequestAddon.setRequestStatus(taskRequest.getRequestStatus());
			taskRequestAddon.setRequestDate(taskRequest.getRequestDate());
			taskRequestAddon.setTaskId(taskRequest.getTaskId());
			taskRequestAddOnList.add(taskRequestAddon);
		}
		return taskRequestAddOnList;
	}
	
	public void undoTaskReuqest(Long id) {
		TaskRequest taskRequest = taskRequestRepository.findById(id).orElseThrow(()-> new RuntimeException("Task Request not found"));
		if(taskRequest != null) {
			taskRequestRepository.deleteById(id);
		}
	}
}
