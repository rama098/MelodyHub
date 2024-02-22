package com.example.demo.services;

import com.example.demo.entities.CustomerPlayList;
import com.example.demo.entities.Users;

public interface UsersService {
	public String addUser(Users users);
	
	public boolean getEmailId(String email);
	
	public boolean validlogin(String email,String password);
	
	public String getRole(String email);
	
	public Users getUser(String email);

	public void updateUSer(Users users);
	
	public void updatePassUSer(Users users);

	public void addUserPlayList(Users user, CustomerPlayList plist);
}
