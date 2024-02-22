package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.AdminPlayList;
import com.example.demo.entities.Songs;
import com.example.demo.entities.Users;
import com.example.demo.services.AdminPlayListService;
import com.example.demo.services.SongsService;
import com.example.demo.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UsersService userSer;
	
	@Autowired
	SongsService songSer;
	
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users users)
	{
		//boolean status=userSer.getEmailId(user.getEmail());
		
		if(userSer.getEmailId(users.getEmail())==false)
		{
			userSer.addUser(users);
			return "registersucce";
		}
		else
		{
			return "registerfail";
		}
	}
	@PostMapping("/login")
	public String validateUser(@RequestParam String email,@RequestParam String password,HttpSession session)
	{
		//boolean status=userSer.login(email, password);
		if(userSer.getEmailId(email)==false)
		{
			return "loginfail";
		}
	
		else if(userSer.validlogin(email, password)==true)
		{
			session.setAttribute("email", email);
			if(userSer.getRole(email).equals("admin"))
			{
				return "adminhome";
			}
			else if(userSer.getRole(email).equals("user"))
			{
				return "customerhome";
			}
			
			
		}
		return "loginfail";
	}
	
	
	//logout function
	@PostMapping("/logout")
	public String logOut(HttpSession session)
	{

		session.invalidate();
		
		return "login";
	}
	
	
	
	
	/*@PostMapping("/register")
	public String addUser(
			@RequestParam String username,
			@RequestParam String email,
			@RequestParam String password,
			@RequestParam String gender,
			@RequestParam String role,
			@RequestParam String address)
	{
		
		System.out.println(username+", "+email+", "+password+", "+
		gender+", "+role+", "+address);
		
		return null;
	}*/
	

}
