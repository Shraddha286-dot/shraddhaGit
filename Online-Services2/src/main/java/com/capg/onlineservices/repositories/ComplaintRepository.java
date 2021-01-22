package com.capg.onlineservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.capg.onlineservices.models.Complaint;
import com.capg.onlineservices.models.Employee;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {
	public Complaint findByComplaintId(int complaintId);
	@Transactional
	@Modifying
	public Iterable<Complaint> findByCustomerServiceName(String customerServiceName);
	
	
	//Iterable<Complaint> findByEmpFname(String customerServiceName);
}
