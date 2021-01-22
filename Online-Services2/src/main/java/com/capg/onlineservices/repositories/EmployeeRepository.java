package com.capg.onlineservices.repositories;

import com.capg.onlineservices.models.Employee;
import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	@Transactional
	@Modifying
	Iterable<Employee> findByEmpFnameAndEmpLname(String empFname,String empLname);
	Iterable<Employee> findByEmpFname(String empFname);
	Iterable<Employee> findByEmpLname(String empLname);
	//@Query("UPDATE Employee e set e.flag='Y',e.lastUpdated=?2 WHERE e.empid=?1")
	//public int findByEmployeeId(int empid,LocalDateTime lastUpdated);
	
	//public int findByEmpid(int empid,LocalDateTime lastUpdated);
	
	public Employee findByEmpid(int empid);
	//public Employee findByEmployeeId(int empid);

	//public Employee findByEmployeeId(int employeeId);

}
