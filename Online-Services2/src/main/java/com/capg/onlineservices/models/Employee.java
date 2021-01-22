package com.capg.onlineservices.models;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empid;
	
	
	@Column
	private String employeeAddress;
	
	
	@Column
	private String employeeContactNo;
	
	@Column
	private String employeePassword="abcd@123";
	
	
	@Column(name="emp_fname")
	private String empFname;
	
	@Column(name="emp_lname")
	private String empLname;
	
	@Column(name="emp_mail_id")
	private String empMail_id;
	
	@Column(name="emp_role")
	private String empRole;
	
	@Column(name="emp_ctc")
	private float empCtc;
	
	@Column(name="emp_doj")
	private String empDoj;
		
	@Column
	@Pattern(regexp ="[YyNn]",message = "Flag should be either 'Y' or 'N'")
	private String flag="N";
	
	private LocalDateTime lastUpdated;
	
	public Employee(int empid,  String empFname, String empLname,String employeeAddress) {
		
		this.empid = empid;
		this.employeeAddress = employeeAddress;
		this.empFname = empFname;
		this.empLname = empLname;
	}
	public Employee() {
		
		// TODO Auto-generated constructor stub
	}

	

	public Employee(int empid, String employeeAddress, String employeeContactNo, String employeePassword,
			String empFname, String empLname, String empMail_id, String empRole, float empCtc, String empDoj,
		 @Pattern(regexp = "[YyNn]", message = "Flag should be either 'Y' or 'N'") String flag,
			LocalDateTime lastUpdated) {
		super();
		this.empid = empid;
		this.employeeAddress = employeeAddress;
		this.employeeContactNo = employeeContactNo;
		this.employeePassword = employeePassword;
		this.empFname = empFname;
		this.empLname = empLname;
		this.empMail_id = empMail_id;
		this.empRole = empRole;
		this.empCtc = empCtc;
		this.empDoj = empDoj;
		this.flag = flag;
		this.lastUpdated = lastUpdated;
	}
	public int getEmpid() {
		return empid;
	}



	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeContactNo() {
		return employeeContactNo;
	}

	public void setEmployeeContactNo(String employeeContactNo) {
		this.employeeContactNo = employeeContactNo;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	//public void setEmployeeDetailsUpdatedAt(LocalDateTime employeeDetailsUpdatedAt) {
		//this.employeeDetailsUpdatedAt = employeeDetailsUpdatedAt;
	//}

	public String getEmpFname() {
		return empFname;
	}

	public void setEmpFname(String empFname) {
		this.empFname = empFname;
	}

	public String getEmpLname() {
		return empLname;
	}

	public void setEmpLname(String empLname) {
		this.empLname=empLname;
		}
	
	
	public String getEmpMail_id() {
		return empMail_id;
	}

	public void setEmpMail_id(String empMail_id) {
		this.empMail_id = empMail_id;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	public float getEmpCtc() {
		return empCtc;
	}

	public void setEmpCtc(float empCtc) {
		this.empCtc = empCtc;
	}

	public String getEmpDoj() {
		return empDoj;
	}

	public void setEmpDoj(String empDoj) {
		this.empDoj = empDoj;
	}


	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	
}