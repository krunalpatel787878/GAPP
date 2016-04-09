package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Application;
import gapp.model.User;
import gapp.model.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {
	 @PersistenceContext
	    private EntityManager entityManager;

	    @Override
	    public User getUser( Integer id )
	    {
	        return entityManager.find( User.class, id );
	    }

	    @Override
	    public List<User> getUsers()
	    {
	        return entityManager.createQuery( "from User where  isValid='true' order by id ", User.class ).getResultList();
	    }

		@Override
		public User isValid(String email, String password) {
				User u = null;
			try{
			 u = entityManager.createQuery( "from User where isValid='true' and LOWER(email)= LOWER(:email) and password = :password", User.class )
	    			.setParameter( "email", email )
	    			.setParameter( "password", password )
	    			.getSingleResult();
			}
			catch(NoResultException rs){
				
			}
			
			return u;
		}
		
		    @Transactional
		    @Override
		    public User saveUser( User user )
		    {
		        return entityManager.merge( user );
		    }

			@Override
			public User findByEmail(String email) {
			
				User u = null;
				try{
				 u = entityManager.createQuery( "from User where lower(email)= lower(:email) ", User.class )
		    			.setParameter( "email", email )
		    			.getSingleResult();
				}
				catch(NoResultException rs){
					
				}
				return u;
			}

			
}
