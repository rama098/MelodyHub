package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.demo.entities.AdminPlayList;
import com.example.demo.entities.Songs;
import com.example.demo.entities.Users;
import com.example.demo.services.AdminPlayListService;
import com.example.demo.services.SongsService;
import com.example.demo.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminPlayListController {
	@Autowired
	AdminPlayListService pser;
	
	@Autowired
	SongsService songSer;
	
	@Autowired
	UsersService uSer;
	
	@GetMapping("/map-createplaylist")
	public String createPlayList(Model model)
	{
	     List<Songs>songslist=songSer.fetchAll();
	     model.addAttribute("songs", songslist);
	   
	   return "createplaylist";  
	} 
	
	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute AdminPlayList playlist)
	{
		//adding play list
		if(pser.validateName(playlist.getName())==false)
		{
		    pser.addPlayList(playlist);
		  
		  List<Songs>ll=playlist.getSongs();
		  for(Songs song:ll)
		  {
			  song.getPlist().add(playlist);
			  songSer.updateSong(song);
		  }
			return "addplaylistsucce";
		 
		}else 
		{
		  return "addplaylistfail";
		}
	}
	
	@GetMapping("/map-viewplaylist")
	public String viewPlayList(Model model,HttpSession session)
	{
		String email=(String)session.getAttribute("email");
		
		List<AdminPlayList>plist=pser.fecthAdminPlayList(email);
		model.addAttribute("plist", plist);
		
		return "viewplaylist";
	    
	}

}
