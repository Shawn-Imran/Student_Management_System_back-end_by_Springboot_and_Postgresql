package com.admin.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.crud.model.User;
import com.admin.crud.repo.CrudRepo;

@Service
public class CrudService {

	@Autowired
	private CrudRepo repo;
	
	
	
	
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	public User fetchUser(String stid) {
		return repo.findByStid(stid);
	}
	
	public User fetchUserLogin(String stid, String password) {
		return repo.findByStidAndPassword(stid, password);
	}
	
	
	
	
	
	
	
	
	
	public List<User> fetchuserList(){
		return repo.findAll();
	}
	
	public User saveUserToDB(User user) {
		return repo.save(user);
	}
	
	
	public Optional<User> fetchUserByIid(int id) {
		return repo.findById(id);
	}
	
	public User updateUser(User user) {
		return repo.save(user);
		
	}
	
	public String deleteUserById(int id) {
		String result;
		try {
			repo.deleteById(id);
			result="Successfully deleted.";
		} catch (Exception e) {
			result="Student id can't find.";

		}
		return result;
	}
}


