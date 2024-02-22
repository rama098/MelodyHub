package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.CustomerPlayList;



public interface CustomerPlayListRepository extends JpaRepository<CustomerPlayList,Integer> {
	public CustomerPlayList findByName(String name);

}
