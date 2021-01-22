package com.capg.onlineservices.controllers;

import java.awt.PageAttributes.MediaType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import javax.xml.bind.ValidationException;

//import javax.validation.ValidationException;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.onlineservices.services.EmployeeService;
import com.capg.onlineservices.models.Employee;
import com.capg.onlineservices.repositories.EmployeeRepository;
	
	 @RestController
	 @RequestMapping("/employee")
	 public class EmployeeController {
	 @Autowired
	     private EmployeeService employeeService;

	 @GetMapping("/retrieve")
	 public List<Employee> list(){
	 return employeeService.getAllEmployee();
	 }

	 @PostMapping("/insert")
	     public Employee create(@RequestBody final Employee employee) throws ValidationException{
	 if(employee.getEmpFname().isBlank()) {
	 throw new ValidationException("Employee First Name cannot be blank");
	 }
	 if(employee.getEmpLname().isBlank()) {
	 throw new ValidationException("Employee Last Name cannot be blank");
	 }
	 if(employee.getEmpMail_id().isBlank()) {
	 throw new ValidationException("Employee mail id cannot be blank");
	 }
	         return employeeService.create(employee);
	     }

	     @GetMapping("/empid/{empid}")
	     public Optional<Employee> get(@PathVariable int empid) {
	         return employeeService.findById(empid);
	     }
	    
	     @GetMapping("/search")
	     Iterable<Employee> findByQuery(@RequestParam(value="first",required=false) String empFname,@RequestParam(value="last",required=false) String empLname ){
	 if(empFname!=null && empLname!=null)
	 return employeeService.findByEmpFnameAndEmpLname(empFname, empLname);
	 else if(empFname!=null)
	 return employeeService.findByEmpFname(empFname);
	 else if(empLname!=null)
	 return employeeService.findByEmpLname(empLname);
	 else
	     return employeeService.getAllEmployee();
	     }
	    
	     @PutMapping("/delete")
	 private Employee deleteEmployee(@RequestBody Employee employee) {
	     return employeeService.deleteEmployee(employee);
	 }
	     @PutMapping("/update")
	     public Employee updateEmployeeDetails(@RequestBody Employee employee) throws ValidationException{
	     if(employee.getEmpid()==0) {
	     throw new ValidationException("Please Enter valid Employee ID");
	     }
	     if (employee.getEmpDoj().isBlank()) {
	     throw new ValidationException("Employee DOJ cannot be blank");
	     }
	     if (employee.getEmpRole().isBlank()) {
	     throw new ValidationException("Employee Role cannot be blank");
	     }
	     if(employee.getEmpCtc()==0) {
	     throw new ValidationException("Please enter Valid CTC");
	     }
	    
	     return employeeService.updateEmployeeDetails(employee);
	     }
	     
	     @PostMapping
		  ResponseEntity<String> createEmployee(@Valid @RequestBody Employee employee)
		   { 
			employeeService.add(employee);
		    return ResponseEntity.ok("Employee record  created successfully"); 
		   }
		@PutMapping("/updatecontactno")
		public Employee updateContactno(@RequestBody Employee employee) throws ValidationException
		{
			
			if(employee.getEmployeeContactNo()==null)
			{
				throw new ValidationException("Employee needs to add contact");
			}
			if(employee.getEmployeeContactNo().isBlank()) 
			{
				throw new ValidationException("Employee contact cannot be blank");
			}
			if(employee.getEmpid()==0)
			{
				throw new ValidationException("Employee needs to give the employee id");
			}
			if(employeeService.getSpecificEmployee(employee)==null)
			{
				throw new ValidationException("Employee id does not exist");
			}
			return employeeService.updateEmployeeContact(employee);
		} 
		
		@PutMapping("/updateaddress")
	    public Employee updateAddress(@RequestBody Employee employee) throws ValidationException
	    {
	       
	        if(employee.getEmployeeAddress()==null)
	        {
	            throw new ValidationException("Employee needs to add address");
	        }
	        if(employee.getEmployeeAddress().isBlank())
	        {
	            throw new ValidationException("Employee address cannot be blank");
	        }
	        if(employee.getEmpid()==0)
	        {
	            throw new ValidationException("Employee needs to give the employee id");
	        }
	        if(employeeService.getSpecificEmployee(employee)==null)
	        {
	            throw new ValidationException("Employee id does not exist");
	        }
	        return employeeService.updateEmployeeAddress(employee);
	    }
		
		@PutMapping("/updatepassword")
		public Employee updatePassword(@RequestBody Employee employee) throws ValidationException
		{
			
			if(employee.getEmployeePassword()==null)
			{
				throw new ValidationException("Employee needs to add password");
			}
			if(employee.getEmployeePassword().isBlank()) 
			{
				throw new ValidationException("Employee password cannot be blank");
			}
			if(employee.getEmpid()==0)
			{
				throw new ValidationException("Employee needs to give the employee id");
			}
			if(employeeService.getSpecificEmployee(employee)==null)
			{
				throw new ValidationException("Employee id does not exist");
			}
			return employeeService.updateEmployeePassword(employee);
		}
		
		
	   

	     
	     @ResponseStatus(HttpStatus.BAD_REQUEST)
	 	@ExceptionHandler(MethodArgumentNotValidException.class)
	 	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
	 	    Map<String, String> errors = new HashMap<>();
	 	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	 	        String fieldName = ((FieldError) error).getField();
	 	        String errorMessage = error.getDefaultMessage();
	 	        errors.put(fieldName, errorMessage);
	 	    });
	 	    return errors;
	     }
	     
	     //Hrutvi
	  /*   @RequestMapping("/ctc/{eid}")
	 	public String findCtc(@PathVariable int eid, @RequestBody Employee employee)throws ValidationException {
	    	 if(employeeService.getSpecificEmployee(employee)==null)
		        {
		            throw new ValidationException("Employee id does not exist");
		        }
	 		return employeeService.getEmployeePaymentSlip(eid);
	 		
	 	} 
	     */
	     @RequestMapping("/ctc/{eid}")
		 	public String findCtc(@PathVariable int eid) {
		 		return employeeService.getEmployeePaymentSlip(eid);
		 		
		 	} 
	 }
