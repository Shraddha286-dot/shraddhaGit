package com.capg.onlineservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.login.apiresponses.ApiResponse;
import com.cg.login.apiresponses.LogoutResponse;
import com.capg.onlineservices.models.Login;
import com.capg.onlineservices.services.LoginService;

@RestController
//@RequestMapping("/users")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("users/login")
    public ApiResponse login(@RequestBody Login loginDto){
        return loginService.login(loginDto);
    }
    
    @GetMapping("users/complaint")
    public String customerPage() {
    	return "Complaint Page";
    }
    
    @GetMapping("users/admin")
    public String adminPage() {
    	return "Admin Page";
    }
    
   
    
    @PostMapping("users/logout")
    public LogoutResponse logout() throws InterruptedException
    {
    	return loginService.logout();
    }
    
    @GetMapping("/loggedout")
    public String exit() {
    	return "You have been logged out";
    }
}

