package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TaskRequest;
import com.example.demo.entity.User;
import com.example.demo.entity.UserAddOn;
import com.example.demo.enums.RequestStatus;
import com.example.demo.enums.Role;
import com.example.demo.enums.UserStatus;
import com.example.demo.repository.TaskRequestRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	TaskRequestRepository taskRequestRepository;
	
	public User createUser(User user) {
		user.setRole(Role.ASSOCIATE);
		user.setStatus(UserStatus.AVAILABLE);
		return userRepository.save(user);
	}
	
	public User authenticateUser(User user) {
		User verifyUser = userRepository.getByUsername(user.getUsername());
		if(verifyUser != null) {
			if(verifyUser.getPassword().equals(user.getPassword())) {
				return verifyUser;
			}
			else {
				throw new RuntimeException("Incorrect password");
			}
		}
		throw new RuntimeException("user not found");
	}
	
	public List<UserAddOn> getLeadUsers(Long id){
		List<User> leads = userRepository.getByRole(Role.LEAD);
		if(leads != null) {
			List<UserAddOn> addOnLeads = new ArrayList<UserAddOn>();
			for(User lead: leads) {
				UserAddOn addOnLead = new UserAddOn();
				addOnLead.setId(lead.getId());
				addOnLead.setUsername(lead.getUsername());
				addOnLead.setRole(lead.getRole());
				addOnLead.setStatus(lead.getStatus());
				TaskRequest taskRequest = taskRequestRepository.findByAssigneeIdAndRequesterIdAndRequestStatus(lead.getId(), id, RequestStatus.PENDING);
				if(taskRequest != null) {
					addOnLead.setRequestStatus(taskRequest.getRequestStatus());
				}
				else {
					addOnLead.setRequestStatus(RequestStatus.NA);
				}
				addOnLeads.add(addOnLead);
			}
			return addOnLeads;
		
		}
		throw new RuntimeException("users not found with role lead");
	}
	
	
	public User updateStatus(Long id, UserStatus status) {
		User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("users not found with id: " + id));
		user.setStatus(status);
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		List<User> users = userRepository.findByRoleNot(Role.LEAD);
		if(users != null) {
			return users;
		}
		throw new RuntimeException("users not found");
	}
}
