package com.capg.onlineservices.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//mark class as an Entity
@Entity
//defining class name as Table name
@Table(name="Complaint")
public class Complaint {
	// Defining employee id as primary key
	 	@Id
	 	@GeneratedValue
	 	@Column	 	
	 	private int complaintId;
	 	@Column
	 	private int employeeId;	 	
	 	@Column
	 	private int customerServiceId;
	 	@Column
	 	private String customerServiceName;
	 	@Column
		private String complaintDesc;
	 	@Column
		private String complaintStatus;
	 	@Column
	 	private String createdDate;
	 	@Column
	 	private int createdBy;
	 	@Column
	 	private String modifiedDate;
	 	@Column
	 	private int modifiedBy;
	 	@Column 
	 	private String deletedFlag="N";
	 	
	 	public Complaint() {
	 		
	 	}
	 	
	 	
	 	
		public Complaint(int complaintId, int employeeId, int customerServiceId, String customerServiceName,
				String complaintDesc, String complaintStatus, String createdDate, int createdBy, String modifiedDate,
				int modifiedBy, String deletedFlag) {
			super();
			this.complaintId = complaintId;
			this.employeeId = employeeId;
			this.customerServiceId = customerServiceId;
			this.customerServiceName = customerServiceName;
			this.complaintDesc = complaintDesc;
			this.complaintStatus = complaintStatus;
			this.createdDate = createdDate;
			this.createdBy = createdBy;
			this.modifiedDate = modifiedDate;
			this.modifiedBy = modifiedBy;
			this.deletedFlag = deletedFlag;
		}



		public int getComplaintId() {
			return complaintId;
		}
		public void setComplaintId(int complaintId) {
			this.complaintId = complaintId;
		}
		
		public int getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}
		
		
		
		public int getCustomerServiceId() {
			return customerServiceId;
		}
		public void setCustomerServiceId(int customerServiceId) {
			this.customerServiceId = customerServiceId;
		}
		
		
		public String getCustomerServiceName() {
			return customerServiceName;
		}
		public void setCustomerServiceName(String customerServiceName) {
			this.customerServiceName = customerServiceName;
		}
		public String getComplaintDesc() {
			return complaintDesc;
		}
		public void setComplaintDesc(String complaintDesc) {
			this.complaintDesc = complaintDesc;
		}
		public String getComplaintStatus() {
			return complaintStatus;
		}
		public void setComplaintStatus(String complaintStatus) {
			this.complaintStatus = complaintStatus;
		}
		public String getCreatedDate() {
			return createdDate;
		}
		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}
		public int getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(int customerServiceId) {
			this.createdBy = customerServiceId;
		}
		public String getModifiedDate() {
			return modifiedDate;
		}
		public void setModifiedDate(String modifiedDate) {
			this.modifiedDate = modifiedDate;
		}
		public int getModifiedBy() {
			return modifiedBy;
		}
		public void setModifiedBy(int modifiedBy) {
			this.modifiedBy = modifiedBy;
		}
		public String getDeletedFlag() {
			return deletedFlag;
		}
		public void setDeletedFlag(String deletedFlag) {
			this.deletedFlag = deletedFlag;
		}
		
		
	 			
}
