package com.takeo.ecommerce.service;

import com.takeo.ecommerce.entity.Users;
import com.takeo.ecommerce.exception.RecordNotFoundException;

import java.util.List;



public interface UserDAO  {
	
	
	public int saveuser(Users u);
		
	public List<Users> getAllUsers();
	
    public Users saveOrUpdateBook(Users user); 
			
	public Users getUserById(int uid);
	public boolean deleteUser(Integer id);
			
	public Users findByEmail(String email)throws RecordNotFoundException;
	public Users getUserByIdd(int uid)throws RecordNotFoundException;
			
			
			
			
			
		
			
		
		
	


}
