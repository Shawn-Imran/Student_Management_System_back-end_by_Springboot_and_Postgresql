package com.admin.crud.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.admin.crud.model.User;

public interface CrudRepo extends JpaRepository<User, Integer>{
	
	@Query
	public User findByStid(String stid);
	public User findByStidAndPassword(String stid, String password);
}
