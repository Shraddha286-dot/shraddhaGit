package com.capg.onlineservices.controllers;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.onlineservices.models.Complaint;
import com.capg.onlineservices.models.Employee;
import com.capg.onlineservices.services.ComplaintService;
import com.capg.onlineservices.services.EmployeeService;

//mark class as Controller
@RestController
@RequestMapping("/Complaint")
public class ComplaintController {
	
	 @GetMapping("/retrieve")
	 public List<Complaint> list(){
	 return complaintService.getAllComplaint();
	 }
	//autowire the ComplaintService class
	@Autowired
	private ComplaintService complaintService;
	private EmployeeService employeeService;
//creating a get mapping that retrieves all the Complaint detail from the database
	@GetMapping //("/Complaint")
	public List<Complaint> List(){
		return complaintService.getAllComplaint();
	}
//creating a get mapping that retrieves the detail of a specific Complaint
	@GetMapping("{complaintId}")
	public Complaint findById(@PathVariable int complaintId) {
		return complaintService.findByComplaintId(complaintId);
	}
	
	 @GetMapping("/search")
     Iterable<Complaint> findByQuery(@RequestParam(value="first",required=false) String customerServiceName){
		 if(customerServiceName!=null)
			 return complaintService.findByCustomerServiceName(customerServiceName);
		 else
			 return complaintService.getAllComplaint();
     }

	
	
////creating post mapping that post the Employee detail in the database
	@PostMapping
	public Complaint create(@RequestBody final Complaint complaint) {
		return complaintService.create(complaint);
	}
	
	//Shraddha
    @RequestMapping("/customerservice")   
    public Complaint customerService() {
    	return complaintService.applyCustomerService();
    }

}
