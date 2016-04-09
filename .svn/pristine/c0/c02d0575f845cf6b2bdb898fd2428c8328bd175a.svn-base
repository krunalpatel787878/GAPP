package gapp.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import gapp.model.User;
import gapp.model.dao.UserDao;



@Component
public class UserValidator implements Validator {

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

        if( !StringUtils.hasText( user.getEmail() ) )
            errors.rejectValue( "email", "error.username.required" );

        if( !StringUtils.hasText( user.getPassword()) )
            errors.rejectValue( "password", "error.password.required" );
        
        if( StringUtils.hasText( user.getEmail() ) && StringUtils.hasText( user.getPassword() ) )
        {
        
        if( userDao.isValid(user.getEmail(), user.getPassword())==null)
	        errors.rejectValue( "password", "error.email.unknown" );
        
        }
        
      /* if( StringUtils.hasText( user.getEmail() ) )
        {
          
            if( userDao.findByEmail(user.getEmail()).getEmail().equals( user.getEmail() ) )
                errors.rejectValue( "email", "error.email.notvalid" );
        }*/
        
        

    }

}

