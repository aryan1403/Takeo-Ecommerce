package com.takeo.ecommerce.controller;

import java.util.List;


import com.takeo.ecommerce.entity.Users;
import com.takeo.ecommerce.exception.RecordNotFoundException;
import com.takeo.ecommerce.service.impl.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping("/aboutus")
	public String companyprofile()
	{
		
		return"AboutUs";
	}
	@RequestMapping("/teams")
	public String companyteams()
	{
		
		return"teams";
	}
	@RequestMapping("/why")
	public String why()
	{
		
		return"why.html";
	}
	@RequestMapping("/contact")
	public String contact()
	{
		
		return"contact.html";
	}
	@RequestMapping("/service")
	public String service()
	{
		
		return"Service.html";
	}

	/*@RequestMapping("/")
	public String register()
	{
		
		return"Index.html";
	}*/
	
	/*@RequestMapping("/homeUser")
	public String homeuser()
	{
		
		return"homeUsers.html";
	}*/
	
	@GetMapping("/SignOut")
	public String registration()
	{
		
		return"register";
	}
	 @PostMapping("/saveuserbyAdmin")
	  public  String update(@ModelAttribute Users user, Model model)
		 
	    {   
			int count=service.saveuser(user);
			String msg=" ";
			      if(count!=0)
				       msg="Update Success";
				    else 
				      msg="Try Later!";
			
			   model.addAttribute("msg",msg);
			return"redirect:/getusers";
					}
	  
	 @PostMapping("saveUser")
	  public  String registerUser(@ModelAttribute Users user,Model model)
		 
	    {   
			int count=service.saveuser(user);
			String msg=" ";
			      if(count!=0)
				       msg="Registration Success";
				    else 
				      msg="Try Later!";
			
			model.addAttribute("msg",msg);
			return"index1";
					}
	
	

	@GetMapping("/getusers")
	public String allUsers(Model model)
	{
		List<Users>list=service.getAllUsers();
		model.addAttribute("user",list);
		return("userdisplay");
	}
	
	
	
	@GetMapping("/SignIn")
	public String login()
	{
		
		return"Login";
	}
	
	@GetMapping("/SignUp")
	public String logout()
	{
		
		return"/";
	}

	
	@PostMapping("/loginValidation")
	public String login(@RequestParam("email") String email, @RequestParam("password")String passwor , Model model, HttpSession session) {
	 Users user =service.getUserInfo(email, passwor);
		       session.setAttribute("users", user);
	              if(user!=null) {
	             if (user.getRole_id() == 1)

		      
	             return "redirect:/Admin";
	             
	              else return"redirect:/UserProducts";
	        
	              } else {
	               model.addAttribute("error", "Invalid username or password");
	               return "login";
	        }}
    
	   @GetMapping("/Admin")
	   public String adminPage()
	   {
	    		
	    		return"admin";
	    	}
	   
	   @GetMapping("/DashBoard")
	   public String dashbordPage()
	   {
	    		
	    		return"Dashbord";
	    	}
	   @RequestMapping("Admin/editUser/{uid}")
		public String edituser(@PathVariable int uid,Model model) {
		Users c=service.getUserById(uid);
			model.addAttribute("pol",c);
			return "UserUpdateByAdmin.html";
		}
		@RequestMapping("Admin/deleteUser/{uid}")
		public String deleteUser(@PathVariable int uid) {
			//int userId=SecurityUtils.getCurrentUser().getUid();
			service.deleteUser(uid);
			return "redirect:/getusers";
		}
		@RequestMapping("/findpsw")
		public String searchpsw()
		{
			
			return"SearchPassword";
		}
		
		@GetMapping("/findpassword")
		public String displayBookById(@RequestParam("email") String email, @NotNull Model model) {
		    try {
		        Users b = service.findByEmail(email);
		        model.addAttribute("psw", b);
		        
		    } catch (RecordNotFoundException e) {
		        model.addAttribute("msg", "User not found");
		    }
			return "login";

		}
	@GetMapping("/UserProfile")
	public String userProfile(@NotNull HttpSession session, Model model) {
		Users user = (Users) session.getAttribute("users");
		System.out.println(user.getUname());
		if (user == null) {
			return "redirect:/login";
		}

		model.addAttribute("User",user);

		return "UserProfile";
	}
	@RequestMapping("User/editUser/{uid}")
	public String editByuser(@PathVariable int uid,Model model) {
		Users c=service.getUserById(uid);
		model.addAttribute("pol",c);
		return "updateUser";
	}
	@RequestMapping("User/deleteUser/{uid}")
	public String deleteByUser(@PathVariable int uid) {
		//int userId=SecurityUtils.getCurrentUser().getUid();
		service.deleteUser(uid);
		return "redirect:/getusers";
	}
	}

	
	  
