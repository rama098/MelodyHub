package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Songs;
import com.example.demo.repositories.SongsRepository;

@Service
public class SongsServiceImplements implements SongsService{
	@Autowired
     SongsRepository songrepo;
	@Override
	public String addSong(Songs song) {
		// TODO Auto-generated method stub
		songrepo.save(song);
		return "song add";
	}
	@Override
	public boolean songExists(String name) {
		if(songrepo.findByName(name)==null)
		{
			return false;
		}else
		{
			return true;
		}
		
	}
	@Override
	public List<Songs> fetchAll() {
		List<Songs>songslist=songrepo.findAll();
		return songslist;
	}
	@Override
	public void updateSong(Songs song) {
		songrepo.save(song);
	}
	@Override
	public void updateUserSongs(Songs song) {
		// TODO Auto-generated method stub
		songrepo.save(song);
	}
	
	
	

}
