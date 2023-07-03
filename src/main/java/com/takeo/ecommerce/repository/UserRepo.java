package com.takeo.ecommerce.repository;

import java.util.List;

import com.takeo.ecommerce.entity.Users;
import com.takeo.ecommerce.exception.RecordNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;





@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

	//findByxxx(-) Methods xxx stands on Entityclassname
	//Unmame /Address should be match
	Users findByEmailAndPassword(String email,String password);
	//Users findByUname(String uname,String address);
	
	Users findByEmail(String email)throws RecordNotFoundException;
	
	//Customized Queries
	
	//@Query("from Users")
	//List<Users> findAll();
	
	//@Query("select uname from Users")
	//List<String> getNames();
	
	
	
	
}
