package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.AdminPlayList;

public interface AdminPlayListService {
	public String addPlayList(AdminPlayList playlist);
	
	public boolean validateName(String name);
	
	public List<AdminPlayList> fecthPlayList();

	public void addUserplayList(AdminPlayList plist);

	public List<AdminPlayList> fecthAdminPlayList(String email);
	
	

}
