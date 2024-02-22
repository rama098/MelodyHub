package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.CustomerPlayList;



public interface CustomerPlayListService {
public String addPlayList(CustomerPlayList playlist);
	
	public boolean validateName(String name);
	
	//public List<CustomerPlayList> fecthPlayList();

	public void addUserplayList(CustomerPlayList plist);

	public List<CustomerPlayList> fecthPlayList(String email);
}
