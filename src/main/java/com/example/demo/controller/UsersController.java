package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.LoginData;
import com.example.demo.entities.Users;
import com.example.demo.services.UsersService;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
@CrossOrigin("*")
@RestController
public class UsersController {
	@Autowired
	UsersService service;
	@PostMapping("/register")
	public String addUsers(@ModelAttribute Users user) {
		System.out.println("addusers method is called");
		boolean userStatus = service.emailExists(user.getEmail());
		if(userStatus==false) {
		service.addUser(user);
		System.out.println("user added");
		}
		else {
			System.out.println("user already exists");
		}
		System.out.println("addusers method is completed");
		return "home";
	}
	@PostMapping("/validate")
	public String validate(@RequestBody LoginData data,HttpSession session, Model model ) {
		String email= data.getEmail();
		String password = data.getPassword();
		System.out.println("call received");
		if(service.validateUser(email, password)== true) {
			String role =service.getRole(email);
			if(role.equals("admin")) {
				return "adminHome";
			}
			else {
			return "customerHome";
			}
		}
		else {
			return "login";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	
}
