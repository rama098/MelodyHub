package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.CustomerPlayList;
import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;
@Service
public class UsersServiceImplements implements UsersService {

	@Autowired
	UsersRepository userrepo;
	
	@Override
	public boolean getEmailId(String email) {
		
		if(userrepo.findByEmail(email)==null)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}


	@Override
	public String addUser(Users users) {
		userrepo.save(users);
		return "Object is saved";
	}


	@Override
	public boolean validlogin(String email,String password) {
		//User user=userrepo.findByEmail(email);
		//String db_password=user.getPassword();
		if(userrepo.findByEmail(email).getPassword().equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}


	@Override
	public String getRole(String email) {
		//User user=userrepo.findByEmail(email);
		//String db_role=user.getRole();
		return userrepo.findByEmail(email).getRole();
	}


	@Override
	public Users getUser(String email) {
		
		return userrepo.findByEmail(email);
	}


	@Override
	public void updateUSer(Users users) {
		userrepo.save(users);
		
	}


	@Override
	public void updatePassUSer(Users users) {
		userrepo.save(users);
		
	}


	@Override
	public void addUserPlayList(Users user, CustomerPlayList plist) {
		// TODO Auto-generated method stub
		user.getCustmPlayList().add(plist);
		userrepo.save(user);
		
	}

}
