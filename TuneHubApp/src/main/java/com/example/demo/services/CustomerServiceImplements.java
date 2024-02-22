package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.CustomerPlayList;
import com.example.demo.entities.Users;
import com.example.demo.repositories.CustomerPlayListRepository;
import com.example.demo.repositories.UsersRepository;

@Service
public class CustomerServiceImplements implements CustomerPlayListService{

	@Autowired
	CustomerPlayListRepository custRepo;
	
	
	@Override
	public String addPlayList(CustomerPlayList plist) {
		custRepo.save(plist);
		return "addded";
	}

	@Override
	public boolean validateName(String name) {
		if(custRepo.findByName(name)==null)
		{
		return false;
		}else
		{
			return true;
		}
	}

//	@Override
//	public List<CustomerPlayList> fecthPlayList() {
//		
//		return custRepo.findAll();
//	}

	@Override
	public void addUserplayList(CustomerPlayList plist) {
		custRepo.save(plist);
		
	}
	@Autowired
UsersRepository userRepo;
@Override
public List<CustomerPlayList> fecthPlayList(String email) {
	// TODO Auto-generated method stub
	Users user=userRepo.findByEmail(email);
	List<CustomerPlayList>list=user.getCustmPlayList();
	return list;
	
}
}
