package com.capg.onlineservices.services;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlineservices.models.Employee;
import com.capg.onlineservices.models.PaymentSlip;
import com.capg.onlineservices.repositories.EmployeeRepository;
import com.google.gson.Gson;


@Service
public class EmployeeService  {

	@Autowired
 	EmployeeRepository employeeRepository;
	PaymentSlip paymentSlip1;
	Employee employee,employee1  ;
	float hra,coupon,PF,anotherPF,tax,profftax ,others,basicsal,monthsal,netsal;
	float ctc;
	static float ctcend=0;
	//int employeeId;
	//String employeeFName,employeeLName,employeeAddress; 
	//String empFName ,empLName,empAddress ;
	
	Gson gson = new Gson();
	String empGson,empGson1,empGson2;
	
	public List<Employee> getAllEmployee() {
		List<Employee> employee = new ArrayList<Employee>();
	       employeeRepository.findAll().forEach(emp1 -> employee.add(emp1));
	       	return employee;
		}
	
	public Employee add(Employee employee) {
		return employeeRepository.save(employee);
 	}
	
	public Employee create(Employee employee) {
 		//System.out.println("saveOrUpdate");
		LocalDateTime lastUpdated=LocalDateTime.now();
		employee.setLastUpdated(lastUpdated);
       	return employeeRepository.saveAndFlush(employee);
 	}
	
	public Optional<Employee> findById(int empid) {
		return employeeRepository.findById(empid);
	}
	
	public Employee deleteEmployee(Employee employee) {
		LocalDateTime lastUpdated=LocalDateTime.now();
		employee=employeeRepository.findByEmpid(employee.getEmpid());
		employee.setFlag("Y");
		employee.setLastUpdated(lastUpdated);
		employeeRepository.save(employee);
		return employee;
		
	}
	
	public Employee updateEmployeeDetails(Employee employee) {
		LocalDateTime lastUpdated=LocalDateTime.now();
		Employee employee1=employeeRepository.findByEmpid(employee.getEmpid());
		employee1.setEmpRole(employee.getEmpRole());
		employee1.setEmpCtc(employee.getEmpCtc());
		employee1.setEmpDoj(employee.getEmpDoj());
		employee1.setLastUpdated(lastUpdated);
		employeeRepository.save(employee1);
		return employee1;
		
	}
	
	public Iterable<Employee> findByEmpFnameAndEmpLname(String empFname,String empLname) {
		return employeeRepository.findByEmpFnameAndEmpLname(empFname,empLname);
	}
	
	public Iterable<Employee> findByEmpFname(String empFname) {
		return employeeRepository.findByEmpFname(empFname);
	}
	
	public Iterable<Employee> findByEmpLname(String empLname) {
		return employeeRepository.findByEmpLname(empLname);
	}
	
	
	public Employee updateEmployeeAddress(Employee employee)
	{
		LocalDateTime lastUpdated=LocalDateTime.now();
		Employee employee1 = employeeRepository.findByEmpid(employee.getEmpid());
		employee1.setEmployeeAddress(employee.getEmployeeAddress());
		employee1.setLastUpdated(lastUpdated);
		 employeeRepository.save(employee1);
		return employee1;
	}
	public Employee updateEmployeeContact(Employee employee)
	{
		LocalDateTime lastUpdated=LocalDateTime.now();
		Employee employee1 = employeeRepository.findByEmpid(employee.getEmpid());
		employee1.setEmployeeContactNo(employee.getEmployeeContactNo());
		employee1.setLastUpdated(lastUpdated);
		employeeRepository.save(employee1);
		return employee1;
	}
	public Employee updateEmployeePassword(Employee employee)
	{
		LocalDateTime lastUpdated=LocalDateTime.now();
		Employee employee1 = employeeRepository.findByEmpid(employee.getEmpid());
		employee1.setEmployeePassword(employee.getEmployeePassword());
		employee1.setLastUpdated(lastUpdated);
		 employeeRepository.save(employee1);
		 return employee1;
		
	}
	public Employee getSpecificEmployee(Employee employee)
	{
		Employee findEmployee=employeeRepository.findByEmpid(employee.getEmpid());
		return findEmployee;
	}
		

	
	//Hrutvi Mande
	
	
	 public int findDifference(LocalDate start_date, LocalDate end_date) 
	{ 
		Period diff = Period.between(start_date, end_date); 
		int temp =diff.getYears();
		int mon = diff.getMonths();
		int join_mon = start_date.getMonthValue();
		int sal_mon = end_date.getMonthValue();
		//System.out.println("Join_month: "+join_mon);
		//System.out.println("Join_month: "+sal_mon);
		//System.out.println(slipMonth slipMonth: "+mon);
		//System.out.println(temp);																		
		float temp1=0;
		if (temp==0)
		{
		temp=temp+1;
		for(int i=1; i<=temp;i++)										
		{
			float z = ctc * 10 ;									
			temp1 = z/100;								
			ctc = ctc + temp1;									
			ctcend=ctc;	
		}
		}
		else{
		if( join_mon<=sal_mon)
		{
		for(int i=1; i<=temp;i++)										
		{
			float z = ctc * 10 ;									
			temp1 = z/100;								
			ctc = ctc + temp1;									
			ctcend=ctc;	
		}
		}
		else if(join_mon>sal_mon)
		{
			for(int i=1; i<=temp;i++)										
			{
				float z = ctc * 10 ;									
				temp1 = z/100;								
				ctc = ctc + temp1;									
				ctcend=ctc;	
			}
		
		}
		}
		//System.out.println("\nYour CTC will be "+ctcend);
		return temp;
	}
	
	
	 public  float PaymentSlip(float ctcend2)
	{
		
		monthsal= ctcend2/12;
		//System.out.println("slipMonth sal "+monthsal);
		
		basicsal = (int) (0.64*monthsal);
		//System.out.println("Basic sal "+basicsal);
		
		hra = (int) (0.12*monthsal);
		//System.out.println("HRA "+hra);
		
		coupon = (int) (0.05*monthsal);
		//System.out.println("Coupon "+coupon);
		
		PF = (int) (0.12*monthsal);
		//System.out.println("PF "+PF);
		
		others = (int) (0.24*monthsal);
		//System.out.println("Others "+others);
		
		tax = (int) (0.20*monthsal);
		//System.out.println("Tax "+tax);
		
		profftax = (int) (0.05*monthsal);
		//System.out.println(profftax);
		
		float gross = hra+basicsal+others;
		float deduction = PF+tax+coupon+profftax;
		netsal = gross-deduction;
		
		
		/*System.out.println("\nNet Salary  "+netsal);
		employeeId
		employeeFName 
		employeeLName 
		employeeAddress */
		
		
		System.out.println("|-----------------------------------------------------------|");
		System.out.println("|			Payment Slip			    |");
		System.out.println("|-----------------------------------------------------------|");
		System.out.println("|EmployeeId	|	"+employee.getEmpid()+"|Employee Address	|     "+employee.getEmployeeAddress()+"|"); 
		System.out.println("|Employee Name	|"+employee.getEmpFname()+" "+employee.getEmpLname()+"				    |");
		System.out.println("|-----------------------------------------------------------|");
		System.out.println("|Earnings		     |Deductions		    |");
		System.out.println("|-----------------------------------------------------------|");
		System.out.println("|Basic Salary   |	"+basicsal+"|Provident Fund	|	"+PF+"|");
		System.out.println("|HRA		|	 "+hra+"|Tax		|	"+tax+"|");
		System.out.println("|Others		|	 "+others+"|Coupon		|	"+coupon+"|");
		System.out.println("|		|	     |Proffesional Tax  |	"+profftax+"|");
		System.out.println("|-----------------------------------------------------------|");
		System.out.println("|Total Addition	|	"+gross+"|Total Deduction	|      "+deduction+"|");
		System.out.println("|-----------------------------------------------------------|");
		System.out.println("|		|	     |Net Salary	|      "+netsal+"|");
		System.out.println("|-----------------------------------------------------------|");
		
		/*
		 * PaymentSlip(int hra, int coupon, int pF, int anotherPF, int tax, int profftax, int others, int basicsal,
			int monthsal, int ctc, int netsal, int employeeId, String employeeFname, String employeeLname,
			String employeeAddress)
		 */
		//paymentSlip = new PaymentSlip(hra, coupon, PF, anotherPF, tax, profftax, others, basicsal, monthsal, ctc, netsal,employeeId,employeeFName,employeeLName,employeeAddress);
		paymentSlip1 = new PaymentSlip(hra, coupon, PF, anotherPF, tax, profftax, others, basicsal, monthsal, ctc, netsal);
		//paymentSlip2 = new PaymentSlip(employeeId,employeeFName,employeeLName,employeeAddress);
		employee1 = new Employee(employee.getEmpid(), employee.getEmpFname(),  employee.getEmpLname(), employee.getEmployeeAddress());
		
		return netsal;
	}
	 
	
	
	public String getEmployeePaymentSlip(int id)
	{
		try {
		Scanner sc = new Scanner(System.in);
		employee = employeeRepository.findByEmpid(id);
		String Doj=employee.getEmpDoj();
		ctc= employee.getEmpCtc();

		int join_day = Integer.parseInt(Doj.substring(0,2));
		int join_month = Integer.parseInt(Doj.substring(3,5));
		int join_year = Integer.parseInt(Doj.substring(6));
		
		
		System.out.println("\nEnter the year you wish to see payment slip(eg- 2020): ");
		int slipYear = sc.nextInt();
		System.out.println("Enter the slipMonth you wish to see payment slip(eg- 01): ");
		int slipMonth = sc.nextInt();
		
		LocalDate currentDate= LocalDate.now(); 
	    //System.out.println("Get currentyear "+ currentDate.getYear());
	    
		
	    //Logic to check whether the year is in between joining year and current year
		if(slipYear >= join_year ) 
		{
			if(slipYear == join_year  )			
			{
				if( slipMonth >= join_month)
				{
					LocalDate start_date = LocalDate.of(join_year, join_month, join_day); 
					LocalDate end_date = LocalDate.of(slipYear, slipMonth, join_day); 
					findDifference(start_date, end_date);
					PaymentSlip(ctcend);
				}
				else{
					System.out.println("Your month is lesser than your joinning slipMonth");
				}
			}
			else if(slipYear < currentDate.getYear())
			{
				LocalDate start_date = LocalDate.of(join_year, join_month, join_day); 
				LocalDate end_date = LocalDate.of(slipYear, slipMonth, join_day); 
				findDifference(start_date, end_date);
				PaymentSlip(ctcend);	
			}
			else if( slipYear == currentDate.getYear()  && slipMonth <= currentDate.getMonthValue())
			{
			LocalDate start_date = LocalDate.of(join_year, join_month, join_day); 
			LocalDate end_date = LocalDate.of(slipYear, join_month, join_day); 
			findDifference(start_date, end_date);
			PaymentSlip(ctcend);	
			}
			
			else
			{
				System.out.println("Your year should be between joining year and current year "+currentDate.getYear());
			}
		}
		else
		{
			System.out.println("You have entered year which comes before your Date of Joining. ");
		}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Your value should be in Digits");
		}
		//int netsal = Ctc * slipYear;
		//System.out.println(Doj);
		empGson1 = gson.toJson(paymentSlip1);
		empGson2 = gson.toJson(employee1);
		//return empGson;
		empGson = "Payment Slip: "+ empGson1+"\nEmployee Details :"+empGson2;
		return empGson;
	
	}

}