package gapp.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import gapp.model.User;
import gapp.model.dao.UserDao;


@Component
public class RegisterUserValidator implements Validator {
	@Autowired
    public UserDao userDao;

	@Override
	public boolean supports( Class<?> clazz )
	{
	// clazz is User.class or a subclass of User
	return User.class.isAssignableFrom( clazz );
	}

	@Override
	public void validate( Object target, Errors errors )
	{
	User user = (User) target;
	
	
	
			 if( StringUtils.hasText( user.getEmail() ) )
			{
			  
			    //if( userDao.findByEmail(user.getEmail()).getEmail().equalsIgnoreCase( user.getEmail() ) )
				 if( userDao.findByEmail(user.getEmail())!=null )
			        errors.rejectValue( "email", "error.email.notvalid" );
			}
	
	
	
	}
}
