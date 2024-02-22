package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.AdminPlayList;

public interface AdminPlayListRepository extends JpaRepository<AdminPlayList,Integer>{
    public AdminPlayList findByName(String name);
    
}
