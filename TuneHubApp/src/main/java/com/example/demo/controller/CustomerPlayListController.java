package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.AdminPlayList;
import com.example.demo.entities.CustomerPlayList;
import com.example.demo.entities.Songs;
import com.example.demo.entities.Users;
import com.example.demo.services.AdminPlayListService;
import com.example.demo.services.CustomerPlayListService;
import com.example.demo.services.SongsService;
import com.example.demo.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerPlayListController {
	@Autowired
	CustomerPlayListService custSer;
	
	@Autowired
	UsersService userSer;
	
	@Autowired
	SongsService songSer;
	
	@GetMapping("/map-exploresongs")
	public String exploreSongs(HttpSession session)
	{
		String email=(String)session.getAttribute("email");
	  Users users=userSer.getUser(email);
		boolean status=users.isPremium();
		if(status ==true)
		{
			
			
			return "exploresongs"; 
		}
		else
		{
			return "samplepayment";
		}
		

	}
	

//	@GetMapping("/map-viewcustomerplaylists")
//	public String viewPlayList(Model model)
//	{
//		List<CustomerPlayList>plist=custSer.fecthPlayList();
//		model.addAttribute("plist", plist);
//		
//		return "viewplaylist";
//	}
	
	@GetMapping("/map-customerviewsongs")
	public String viewSongs(Model model)
	{
		List<Songs>songs=songSer.fetchAll();
		model.addAttribute("songs", songs);
		return"customerviewsongs";
	}

	@PostMapping("/forgotpassword")
	public String forgotPassword(@RequestParam String email,@RequestParam String password)
	{
		if(userSer.getEmailId(email)==true)
		{
		 Users users=userSer.getUser(email);
		 users.setPassword(password);
		
		userSer.updatePassUSer(users);
		return "forgotsucce";
		}
		else
		{
			return "forgotfail";
		}
	}
	@GetMapping("/map-usercreateplaylist")
	public String viewadminPlayList(Model model)
	{
		List<Songs>songs=songSer.fetchAll();
		model.addAttribute("songs", songs);
		
		return "createuserplaylist";
	}
	@PostMapping("m-creatuserplaylist")
	public String addPlayList(@ModelAttribute CustomerPlayList plist,HttpSession session )
	{
		
//		if(custSer.validateName(plist.getName())==false)
//		{
			String email=(String)session.getAttribute("email");
			
			Users user=userSer.getUser(email);
			user.getCustmPlayList().add(plist);
			userSer.addUserPlayList(user,plist);
			
			custSer.addPlayList(plist);
			   
			List<Songs>ll=plist.getSongs();
			for(Songs song:ll)
			{
				song.getCustomerplist().add(plist);
				songSer.updateSong(song);
			}
			return "customerplaylistsucc";
			
//		else
//		{
//			return "customerplaylistfail";
//		}
	}
	@GetMapping("/map-view")
	public String viewUserPlayList(Model model,HttpSession session)
	{
		String email=(String)session.getAttribute("email");
	Users user=userSer.getUser(email);
		List<CustomerPlayList>plist=custSer.fecthPlayList(email);
		model.addAttribute("plist",plist);
		return "viewuserplaylist";
	}

}
