package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Student;
import gapp.model.dao.StudentDao;

@Repository
public class StudentDaoImpl implements StudentDao  {

	 @PersistenceContext
	    private EntityManager entityManager;
	 
	 @Override
	    public List<Student> getStudents()
	    {
	        return entityManager.createQuery( "from Student order by id where  isValid='true' ", Student.class ).getResultList();
	    }

		@Override
		public List<Student> getStudent(String email) {
			return entityManager.createQuery( "from Student where  isValid='true' and  email= :email", Student.class )
	    			.setParameter( "email", email )
	    			.getResultList();
		}

		 @Transactional
		@Override
		public Student saveStudent(Student stu) {
			 return entityManager.merge( stu );
		}

		@Override
		public Student getStudentByApp(int appid) {
			// TODO Auto-generated method stub
			return null;
		}

	
}
