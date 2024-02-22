package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Songs;
import com.example.demo.services.SongsService;

@Controller
public class SongsController {

	
	@Autowired
	SongsService songSer;
	
	@PostMapping("/addsongs")
	public String addSongs(@ModelAttribute Songs song)
	{
		if(songSer.songExists(song.getName())==false)
		{
			songSer.addSong(song);
			return "addsongsucce";
		}
		else
		{
			return "addsongfail";
		}
	}
	@GetMapping("/viewsongs")
	public String readAll(Model model)
	{
		List<Songs>songList=songSer.fetchAll();
		
		model.addAttribute("songs", songList);
		return "viewsongs";
	}
	
	/*@GetMapping("customerviewsongs")
	public String viewSongs(Model model)
	{
	   boolean primeStatus=true;
	   
	   if(primeStatus==true)
	   {
		   List<Songs>songList=songSer.fetchAll();
			
			model.addAttribute("songs", songList);
			return "viewsongs";
	   }
	   else
	   {
		   return "makepayment";
	   }
	}*/
}
