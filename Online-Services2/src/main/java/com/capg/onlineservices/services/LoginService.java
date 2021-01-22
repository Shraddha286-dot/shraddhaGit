package com.capg.onlineservices.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.login.apiresponses.ApiResponse;
import com.cg.login.apiresponses.LogoutResponse;
import com.cg.login.exception.IncorrectPasswordException;
import com.cg.login.exception.UserNotFoundException;
import com.capg.onlineservices.models.Login;
import com.capg.onlineservices.repositories.LoginRepository;


@Transactional
@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginrepository;
	
	public ApiResponse login(Login login) {
        Login user = loginrepository.findByUsername(login.getUsername());
        
        if(user == null) {
        	System.out.println("Login failed. User not found or username is null. Please re-enter.");
        	throw new UserNotFoundException("User does not exist or username is null");
        }
        String role = user.getRole();
        String landingPage="";
        if(!user.getPassword().equals(login.getPassword())){
        	System.out.println("Login failed. Incorrect password. Please re-enter.");
            throw new IncorrectPasswordException("Password mismatch.");
        }
        else if(user.getPassword().equals(login.getPassword()) && role.equalsIgnoreCase("Customer Service Employee"))
        {
        	System.out.println("Login successful for Complaint");
        	landingPage = "http://localhost:8081/Complaint";
        //	return new ApiResponse(200, "Login success", user,landingPage) ;
        }
        
        else if(user.getPassword().equals(login.getPassword()) && role.equalsIgnoreCase("Admin"))
        {
        	System.out.println("Login successful for Admin");
        	landingPage = "http://localhost:8081/employee";
        }
        
        else if(user.getPassword().equals(login.getPassword()) && role.equalsIgnoreCase("General Employee"))
        {
        	System.out.println("Login successful for Employee");
        	landingPage = "http://localhost:8081/employee";
        }
        //System.out.println("Login successful");
        return new ApiResponse(200, "Login success", user, landingPage) ;
     
    }
	
	public LogoutResponse logout() {
		System.out.println("logged out successfully");
		return new LogoutResponse(200, "logged out successfully", null);
	}

}
