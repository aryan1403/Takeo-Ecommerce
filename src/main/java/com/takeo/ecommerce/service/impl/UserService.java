package com.takeo.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import com.takeo.ecommerce.entity.Users;
import com.takeo.ecommerce.exception.RecordNotFoundException;
import com.takeo.ecommerce.repository.UserRepo;
import com.takeo.ecommerce.service.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;






@Service
public class UserService implements UserDAO {
@Autowired
private UserRepo uRepo;

public int saveuser(Users u) {
	Users saveEnt=uRepo.save(u);
	
	if(saveEnt!=null)
		return 1;
	else
	return 0;

}

public List<Users> getAllUsers()
{
	return uRepo.findAll();
	}
 
    public Users getUserInfo(String email,String password) 
    {

    return uRepo.findByEmailAndPassword(email,password);	
       }
	
    
    
    public Users saveOrUpdateBook(Users user) {
		
		 Optional<Users> userOptional = uRepo.findById(user.getUid());
		   Users b= userOptional.get();
	             if (b!=null) 
		    	  b=uRepo.save(b);
		    
	           return b;

	}

	public Users getUserById(int uid) {

	return uRepo.findById(uid).get();
	}


	public boolean deleteUser(Integer id) {
		
		 Optional<Users> userOptional = uRepo.findById(id);
		    Users book=userOptional.get();
		    boolean flag =false;
		    if (book!=null) {
		    	uRepo.deleteById(id);
		       flag=true;
		    } else {
		    	
		        
		    }return flag;
	}

	public Users findByEmail(String email)throws RecordNotFoundException {
		
		Users user = uRepo.findByEmail(email);
	    
	    if (user!=null) 
	        return user;
	     else 
	        throw new RecordNotFoundException("User Not Found");

		
	}

	@Override
	public Users getUserByIdd(int uid) throws RecordNotFoundException {
		Optional<Users> userOptional = uRepo.findById(uid);
		Users user=userOptional.get();

		if (user!=null)
			return user;
		else
			throw new RecordNotFoundException("User Not Found");

	}


}
