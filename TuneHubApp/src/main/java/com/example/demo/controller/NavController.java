package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class NavController {
	
	@GetMapping("/map-register")
	public String registerMapping()
	{
		return "register";
	}
	@GetMapping("/map-login")
	public String loginMapping()
	{
		return "login";
	}
	@PostMapping("/loginfail")
	public String loginFail()
	{
		return "login";
	}
	@PostMapping("/registerfail")
	public String registerFail()
	{
		return "register";
	}
	@GetMapping("/addsong")
	public String addSongs()
	{
		return "addsongs";
	}
	
	@GetMapping("/map-forgot")
	public String forgot()
	{
		return "forgotpassword";
	}
	@GetMapping("/login")
	public String backLogin()
	{
		return "login";
	}
	@GetMapping("/register")
	public String backtoRegister()
	{
		return "register";
	}
	@GetMapping("/map-viewadminplaylist")
	public String mapViewplayList()
	{
		return "map-viewplaylist";
	}
	
}
