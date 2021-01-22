package com.capg.onlineservices.services;

import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

import com.capg.onlineservices.models.Complaint;
import com.capg.onlineservices.models.Employee;
import com.capg.onlineservices.repositories.ComplaintRepository;

//defining the business logic
@Service
public class ComplaintService {
    @Autowired
 	ComplaintRepository complaintRepository;
   

	public List<Complaint> getAllComplaint() {
		
		return complaintRepository.findAll();
	}
	public Complaint findByComplaintId(int complaintId) {
		
		// TODO Auto-generated method stub
		return complaintRepository.findByComplaintId(complaintId);
	}
	
	public Iterable<Complaint> findByCustomerServiceName(String customerServiceName) {
		return complaintRepository.findByCustomerServiceName(customerServiceName);
	}
	
 	
//saving a specific record by using the method save() of CrudRepository
 
	public Complaint create(Complaint complaint) {
		//int employeeId,customerServiceId;
		//String employeeName=complaint.getEmployeeName();
		//String customerServiceName=complaint.getCustomerServiceName();
		//Employee employee=findByEmployeeName(employeeName);
		//Employee employee1=findByEmployeeName(customerServiceName);
		//employeeId=employee.getEmployeeId();
		//customerServiceId=employee1.getEmployeeId();
		SimpleDateFormat date=new SimpleDateFormat("dd/MM/yyyy");
 		Date dt=new Date();
 		//complaint.setEmployeeId(complaint.getEmployeeId());
 		//complaint.setCustomerServiceId(complaint.getCustomerServiceId());
 		complaint.setCreatedDate(date.format(dt));
 		complaint.setCreatedBy(complaint.getCustomerServiceId());
 		complaint.setModifiedDate(date.format(dt));
 		complaint.setModifiedBy(complaint.getCustomerServiceId());
 		complaint.setDeletedFlag("Y");
		return complaintRepository.save(complaint);
	}
	
	//Shraddha Basutkar
	
	public Complaint applyCustomerService() 
	{

		    System.out.println("*********************************************************************************************");
			 System.out.println("                            Online Customer Care Service and Help Desk                       ");
			 System.out.println("*********************************************************************************************");
			 System.out.println("Hello Good Morning!!!!!!!!");
			 System.out.println("Welcome Customer for Solving your Queries");
	        System.out.println("Click the below Number which is related to your Query");
	        Scanner s=new Scanner(System.in);
				System.out.println("\n1.Query related to payment\n2.Query related to profile\n3.Query related to Hardware\n4.Query related to Software\n5Other Queries\n\tEnter Choice: ");
				int choice=s.nextInt();	
				switch(choice)
				{
				case 1:
				System.out.println("1.My Transaction failed\n2.I did not get the OPT Number\n3.I Have not got the payment slip");	
				int choice1=s.nextInt();
				switch(choice1)
				{
				case 1:
					System.out.println("1.Click on the new tab to do the transaction again\n2.Use Different Browser for transaction\n3.Please send ur transaction Id for future updates\n4. Other Queries");	
				    int ch=s.nextInt();
				    switch(ch) 
				    {
				    case 4:
				    	System.out.println("Raise your Query on this email Id 'customerservice@gmail.com'");
				    break;
				    }
					break;			           
				case 2:
					System.out.println("1.Refresh Your page\n2.Check your Deleted messages in Bin Folder\n3.Please wait until the new OPT is being sent\n4.Other Queries");
					int ch5=s.nextInt();
				    switch(ch5)
				    {
				    case 4:
				    	System.out.println("Raise your Query on this email Id 'customerservice@gmail.com'");
				    break;
				    }
					break;
				case 3:
					System.out.println("1.Contact on this number 9999911111 to get your payment slip\n2.Send your email Id to Customer service's mail Id ''customerservice@gmail.com");
					System.out.println("\n\n\tI hope we have solved your Queries\n\t If your queries are not solved yet then please Raise your query on this Email Id 'Complaint@gmail.com'!!!!!");
					int ch8=s.nextInt();
				    switch(ch8)
			 	    {
				    case 4:
				    	System.out.println("Raise your Query on this email Id 'customerservice@gmail.com'");
				    break;
				    }
					break;				
					}
				break;			//payment query
				
				case 2:
					System.out.println("1.I have to Change my profile photo\n2.I want to edit my Bio \n3.I want to change my email Id");	
					int choice2=s.nextInt();	
					switch(choice2)
					{
					case 1:
						System.out.println("1.Click on the Edit option on your profile Picture\n2.Use Different Browser for Changing profile\n3.Other Queries");	
						int ch7=s.nextInt();
					    switch(ch7) 
					    {
					    case 3:
					    	System.out.println("Raise your Query on this email Id 'customerservice@gmail.com'");
					    break;
					    }	
						break;				           
					case 2:
						System.out.println("1.Click on the edit button of your bio\n2.Save the details of updated Bio\n3.Other Queries");
						int ch9=s.nextInt();
					    switch(ch9)
					    {
					    case 3:
					    	System.out.println("Raise your Query on this email Id 'customerservice@gmail.com'");
					    break;
					    }
						break;
					case 3:
						System.out.println("1.Click on the add account and follow the steps\n2.Remove the current account And then add new one\n3.Other Queries");
						int ch10=s.nextInt();
					    switch(ch10)
					    {
					    case 3:
					    	System.out.println("Raise your Query on this email Id 'customerservice@gmail.com'");
					    	break;
					    	}
					    System.out.println("\n\n\tI hope we have solved your Queries,\\nThankyou for asking your Queries, \tOur Team is working best to solve Your problems!!!!!");
						break;
						}		
					break;    //profile query
					
				case 3:
					System.out.println("1.I want to replace my product\n2.I want different part of the same hardware\n3.I want the extra plugins wires for the same hardware");	
					int choice3=s.nextInt();	
					switch(choice3)
					{
					case 1:
						System.out.println("1.Click on the replace button \n2.Enter the product Id and send the mail to helpdesk \n3.Other Queries");	
						int ch11=s.nextInt();
					    switch(ch11)
					    {
					    case 3:
					    	System.out.println("Raise your Query on this email Id 'customerservice@gmail.com'");
					    	break;
					    	}
						break;	
						case 2:
							System.out.println("1.Please enter your Product Id and send mail to help desk\n2.Contact help desk on this number 9999911111\n3.Other Queries");
							int ch12=s.nextInt();
							switch(ch12) 
							{
							case 3:
								System.out.println("Raise your Query on this email Id 'customerservice@gmail.com'");
								break;	
								}
							break;
							case 3:
								System.out.println("1.Contact on this number 9999911111 to get your extra wires\n2.Send your email Id to Customer service's email Id\n3.Other Queries");
								int ch2=s.nextInt();
								switch(ch2) 
								{
								case 3:
									System.out.println("Raise your Query on this email Id 'customerservice@gmail.com'");
									break;
									}
								System.out.println("\n\n\tI hope we have solved your Queries,\nThankyou for asking your Queries,\t Our Team is working best to solve Your problems!!!!!");
								break;
								}
					break;    //hardware query
					
					case 4:
						System.out.println("1.My software is getting hanged\n2.I am not able to open the software\n3.It is asking me to pay premium amount");	
						int choice4=s.nextInt();
						switch(choice4) 
						{
						case 1:
							System.out.println("1.Restart your system \n2.Use different Port Number \n3.Uninstall the software and download it again\n4.Other Queries");
							int ch13=s.nextInt();
							switch(ch13)
							{
							case 4:
								System.out.println("Raise your Query on this email Id 'customerservice@gmail.com'");
								break;
								}
							break;
							case 2:
								System.out.println("1.Use '1234' as your Port Number \n2.Check it in your Recycle bin\n3.Refresh Your Page!!!!\n4.Other Queries");
								int ch14=s.nextInt();
								switch(ch14)
								{
								case 4:
									System.out.println("Raise your Query on this email Id 'customerservice@gmail.com'");
									break;
									}
								break;
								case 3:
									System.out.println("1.Contact on this number 9898989898 to remove the premium software update\n2.Send your email Id to Customer service's email Id:- 'customerservice@gmail.com\n3.Other Queries");
									int ch3=s.nextInt();
									switch(ch3)
									{
									case 3:
										System.out.println("Raise your Query on this email Id 'customerservice@gmail.com'");
										break;
										}
									System.out.println("\n\n\tI hope we have solved your Queries,\nThankyou for asking your Queries, Our Team is working best to solve Your problems!!!!!");
									break;
									}
						break;
						case 5:		
							default:
								System.out.println("Please Raise your Complaint by Contacting with our team on Email Id 'raisecomplaint@gmail.com'");
								System.out.println("Kindly Contact on this Number:9988998898");
								break;			
							}
				return null;
				
	}
}
