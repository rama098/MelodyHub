package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AdminPlayList;
import com.example.demo.entities.Users;
import com.example.demo.repositories.AdminPlayListRepository;
import com.example.demo.repositories.UsersRepository;

@Service
public class AdminPlayListImplements implements AdminPlayListService{
	
	@Autowired
	AdminPlayListRepository prepo;

	@Override
	public String addPlayList(AdminPlayList playlist) {
		prepo.save(playlist);
		return "PlayList is created";
	}

	@Override
	public boolean validateName(String name) {
		if(prepo.findByName(name)==null)
		{
			return false;
		}
		else
		{
		  return true;
		}
		
	}

	@Override
	public List<AdminPlayList> fecthPlayList() {
		List<AdminPlayList>plist=prepo.findAll();
		
		return plist;
	}

	@Override
	public void addUserplayList(AdminPlayList plist) {
		// TODO Auto-generated method stub
		prepo.save(plist);
		
	}
	
	@Autowired
	UsersRepository useRepo;

	@Override
	public List<AdminPlayList> fecthAdminPlayList(String email) {
		Users user=useRepo.findByEmail(email);
		List<AdminPlayList>plist=user.getUserPlayList();
		return plist;
	}
	

}
