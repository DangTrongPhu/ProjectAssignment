package com.mkyong.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.messeage.Response;
import com.mkyong.model.User;
import com.mkyong.service.UserService;
@RestController
@RequestMapping("/api")
public class UserController {	

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllUser() {
		List<User> user =userService.findAll();
		return new Response("Done",user);
	}
	@RequestMapping("login")
	public Response loginUser(HttpServletRequest request,@RequestParam("email") String email,@RequestParam("pass") String pass){
	    HttpSession session = request.getSession();
	   // String hashedPW = BCrypt.hashpw(pass, BCrypt.gensalt(12));
	   
		User user = userService.loginUser(email, pass);
		//BCrypt.checkpw(hashedPW, user.getPass());
		if(user!=null)
		{
			session.setAttribute("quyen",user.getId_roles());  
			return new Response("Done",user);
	
		}
		return new Response("false","Email or password incorrect!");
	}
	@RequestMapping("changepass")
	public Response changepassUser(HttpServletRequest request,@RequestParam("email") String email,@RequestParam("pass") String pass,@RequestParam("passnew") String passnew,@RequestParam("repassnew") String repassnew){	   
		if(!repassnew.equals(passnew))
		{
			return new Response("false","Repassword incorrect, please try again ");
		}
		User user = userService.loginUser(email, pass);
		//BCrypt.checkpw(hashedPW, user.getPass());
		if(user!=null)
		{
			user.setPass(passnew);
			user = userService.save(user);
			return new Response("Done",user);
	
		}
		return new Response("false","Email or password incorrect!");
	}
	@RequestMapping(value = "user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllEmployees() {
		return userService.findAll();
	}
}
