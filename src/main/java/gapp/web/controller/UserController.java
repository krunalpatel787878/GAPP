package gapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import gapp.model.User;
import gapp.model.dao.ApplicationDao;
import gapp.model.dao.UserDao;
import gapp.web.validator.RegisterUserValidator;
import gapp.web.validator.UserValidator;

@Controller
public class UserController {

  
	
	 @Autowired
	    private UserDao userDao;
	 
	 @Autowired
	    private ApplicationDao appDao;
	 
	 @Autowired
	    UserValidator userValidator;
	 
	 @Autowired
	    RegisterUserValidator registeruserValidator;

	/* @RequestMapping("/users.html")
	    public String departments( ModelMap models )
	    {														
	        models.put( "users", departmentDao.getApplicationByStudent("student1@localhost.localdomain"));
	        return "users";
	    }*/

	 @RequestMapping(value = "/user/login.html", method = RequestMethod.POST)
	    public String login(  HttpSession session,@ModelAttribute User user, BindingResult bindingResult,ModelMap models   )
	    {														
	
		 
		 userValidator.validate( user, bindingResult );
	       

		
			 
			 if( bindingResult.hasErrors() ) {
		    	  /* model =  new ModelAndView("login");
		    	   model.addObject("user",user);*/
		    		   return "user/login";
		    	   }
			 
			 User u = userDao.isValid(user.getEmail(), user.getPassword());
			 if(u!=null){
				//models.put("user",u);
				 session.setAttribute("uid", u.getId());
				 if(u.getUsertype().equals("Admin"))
				return "redirect:/user/home.html";
				 else if(u.getUsertype().equals("Student")){

						return "redirect:/user/homestudent.html";
				 }
				 else if(u.getUsertype().equals("Staff"))
						return "redirect:/user/homestaff.html";
				 
				 return null;
			 }
			 else
				 return "user/login";
		
	    }
	 
	 @RequestMapping(value = "/user/login.html", method = RequestMethod.GET)
	    public String login( HttpServletRequest request, @ModelAttribute User user,HttpSession session )
	    {														
		 session.invalidate();
	        return "user/login";
	    }
	 
	 @RequestMapping(value = "/user/home.html", method = RequestMethod.GET )
	    public String home(  ModelMap models,HttpSession session)
	    {														
		  	String id = session.getAttribute("uid").toString();
		  	models.put("user", userDao.getUser(Integer.parseInt(id)));
	        return "user/home";
	    }
	 
	 
	 
	 @RequestMapping(value = "/user/homestaff.html", method = RequestMethod.GET )
	    public String homestaff(  ModelMap models,HttpSession session)
	    {														
		  	String id = session.getAttribute("uid").toString();
		  	models.put("user", userDao.getUser(Integer.parseInt(id)));
	        return "user/homestaff";
	    }
	 
	 
	 @RequestMapping(value = "/user/homestudent.html", method = RequestMethod.GET )
	    public String homestudent(  ModelMap models,HttpSession session)
	    {														
		  	String id = session.getAttribute("uid").toString();
		  	models.put("user", userDao.getUser(Integer.parseInt(id)));
		 	models.put("app", appDao.getApplicationByStudent(Integer.parseInt(id)));
	        return "user/homestudent";
	    }
	 @RequestMapping(value = "/user/registration.html", method = RequestMethod.GET)
	    public String add( ModelMap models )
	    {
	        models.put( "user", new User() );
	        return "user/registration";
	    }

	    @RequestMapping(value = "/user/registration.html", method = RequestMethod.POST)
	    public String add( @ModelAttribute User user, BindingResult bindingResult )
	    {
	    	
			 registeruserValidator.validate( user, bindingResult );
	    	if( bindingResult.hasErrors() ) {

		    		   return "user/registration";
		    	   }
	    	else{
	    		user.setValid(true);
	       user.setUsertype("Student");
	        userDao.saveUser( user );
	        return "redirect:/user/login.html";
	    	}
	    }
	    
}
