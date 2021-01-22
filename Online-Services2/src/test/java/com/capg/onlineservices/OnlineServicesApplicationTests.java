package com.capg.onlineservices;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.checkerframework.checker.nullness.Opt;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import com.capg.onlineservices.controllers.EmployeeController;
import com.capg.onlineservices.models.Complaint;
import com.capg.onlineservices.models.Employee;
import com.capg.onlineservices.repositories.ComplaintRepository;
import com.capg.onlineservices.repositories.EmployeeRepository;


@ContextConfiguration 
@SpringBootTest(classes = OnlineServicesApplication.class)
class OnlineServicesApplicationTests {
	
	@Autowired
	private EmployeeController employeeController;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ComplaintRepository complaintRepository;
	
	@Test
	void test() throws Exception{
		assertThat(employeeController).isNotNull();
	}
	
/*	@Test
	public void Add() {
		RestTemplate rt= new RestTemplate();	
		String url="http:localhost:8081/insert";
		
		Employee employee=new Employee(12,"Mumbai","9999977777","password","Bhavesh","Malhotra","bhaveshmalhotra@gmail.com","Admin",490000.0,"12/10/2015","N",null);
		
		employeeRepository.save(employee);
		Employee[] employoee=rt.getForObject(url,Employee[].class);
		Assertions.assertThat(employee).extracting(Employee::getEmpid).contains(5);
	}*/
	
	/*@Test
	public void AddByComplaintId() {
		RestTemplate rt= new RestTemplate();	
		String url="http:localhost:8081/Complaint";
		
		Complaint complaint=new Complaint(123,111,1234,"Rajan","Software issues","open","",1234,"",1234,"N");
		
		complaintRepository.save(complaint);
		Complaint[] complaints=rt.getForObject(url,Complaint[].class);
		Assertions.assertThat(complaints).extracting(Complaint::getComplaintId).contains(123);
	}
	
	@Test
	public void TestforSearchByName() {
		RestTemplate rt= new RestTemplate();	
		String url="http:localhost:8081/search";
		
		Employee employee=new Employee();
		
		employeeRepository.save(employee);
		Employee[] employoee=rt.getForObject(url,Employee[].class);
		Assertions.assertThat(employee).extracting(Employee::getEmpFname).contains;
	}

	*/

}
