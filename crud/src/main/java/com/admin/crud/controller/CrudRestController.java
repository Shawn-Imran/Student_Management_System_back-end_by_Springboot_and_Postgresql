package com.admin.crud.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.admin.crud.model.User;
import com.admin.crud.services.CrudService;



@RestController
public class CrudRestController {
	@Autowired
	private CrudService service;
	
	
	

	
	@PostMapping("/registration")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception{
		String tempStid = user.getStid();
		if(tempStid != null && "".equals(tempStid)) {
			User obj = service.fetchUser(tempStid);
			if(obj != null) {
				throw new Exception("User with " +tempStid+" is already usered!!");
			}
		}
		User obj = null;
		obj = service.saveUser(user);
		return obj;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception{
		String tempStid = user.getStid();
		String tempPass = user.getPassword();
		User obj = null;
		if(tempStid != null && tempPass != null) {
			obj = service.fetchUserLogin(tempStid, tempPass);
		}
		if(obj == null) {
			throw new Exception("Invalid User!!!");
		}
		return obj;
	}
	
	
	
	
	
	
	
	
	@GetMapping("/getuserlist")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<User> fetchUserList(){
		List<User> users= new ArrayList<>();
		users = service.fetchuserList();
		return users;
	}
	
	@PostMapping("/addusers")
	@CrossOrigin(origins = "http://localhost:4200")
	public User saveUser(@RequestBody User user){
		return service.saveUserToDB(user);
	}
	
	@GetMapping("/getuserbyid/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public User fetchUserById(@PathVariable int id){
		return service.fetchUserByIid(id).get();
		
	}
	
	 @PutMapping("/updateuserbyid/{id}")
	 @CrossOrigin(origins = "http://localhost:4200")
		public User updateUser(@RequestBody User user){
		 return service.updateUser(user);
		}
	
	
	
	@DeleteMapping("/deleteuserbyid/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String DeleteUserById(@PathVariable int id){
		return service.deleteUserById(id);
	}
	
 
    
}
