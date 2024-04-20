package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TaskRequest;
import com.example.demo.enums.RequestStatus;

import java.util.List;


@Repository
public interface TaskRequestRepository extends JpaRepository<TaskRequest, Long> {
	public List<TaskRequest> findByRequesterId(Long requesterId);
	public List<TaskRequest> findByAssigneeId(Long assigneeId);
	public TaskRequest findByAssigneeIdAndRequesterIdAndRequestStatus(Long assigneeId, Long requesterId, RequestStatus status);
	public List<TaskRequest> findByAssigneeIdAndRequestStatus(Long assigneeId, RequestStatus status);
}
