package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Application;
import gapp.model.Student;
import gapp.model.dao.ApplicationDao;


@Repository
public class ApplicationDaoImpl implements ApplicationDao {

	 @PersistenceContext
	    private EntityManager entityManager;

	    @Override
	    public List<Application> getApplication(String dept ,  String term )
	    {
	    	return entityManager.createQuery( "from Application where isValid='true' and program.department.departmentName= :dept and term = :term", Application.class )
	    			.setParameter( "dept", dept )
	    			.setParameter( "term", term )
	    			.getResultList();
	    }

	    @Override
	    public List<Application> getApplications()
	    {
	        return entityManager.createQuery( "from Application where isValid='true' order by id ", Application.class ).getResultList();
	    }

		@Override
		public List<Application> getApplicationByStudent(int id) {
			return entityManager.createQuery( "from Application where isValid='true' and student.user.id= :id", Application.class )
	    			.setParameter( "id", id )
	    			.getResultList();
		}
		
		 @Override
		    public List<Application> getApplicationByStatus(String status )
		    {
		    	return entityManager.createQuery( "from Application where  status.status= :status ", Application.class )
		    			.setParameter( "status", status )
		    			.getResultList();
		    }

		@Override
		public Application getApplicationsById(int id) {
			return entityManager.createQuery( "from Application where isValid='true' and id= :id", Application.class )
	    			.setParameter( "id", id )
	    			.getSingleResult();
		}

		 @Transactional
		@Override
		public Application saveApplication(Application app) {
			 return entityManager.merge( app );
			//entityManager.getTransaction().commit();
			 //entityManager.flush();
			 //return a;
		}

		@Override
		public Student getStudent(int appid) {
			return entityManager.createQuery( "select student from Application where isValid='true' and id= :appid", Student.class )
	    			.setParameter( "appid", appid )
	    			.getSingleResult();
		}
		
}
