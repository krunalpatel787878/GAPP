package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Department;
import gapp.model.User;
import gapp.model.dao.DepartmentDao;


@Repository
public class DepartmentDaoImpl implements DepartmentDao  {

	@PersistenceContext
    private EntityManager entityManager;
	
	    @Override
	    public List<Department> getDepartments()
	    {
	        return entityManager.createQuery( "from Department  where  isValid=true order by id", Department.class ).getResultList();
	    }

		@Override
		public List<Department> getmajorNumbers() {
			return entityManager.createQuery( "select d.departmentname,m.count(*) from Department d inner join DepartmentMajor m where  d.departmentName=m.department.departmentName", Department.class )
			.getResultList();
		}

		@Override
		public Department getDepartment(int id) {
			return entityManager.find( Department.class, id );
		}

		 @Transactional
		    @Override
		public Department saveDepartment(Department department) {
			 return entityManager.merge( department );
		}

		 @Transactional
		@Override
		public Department editDepartment(int id) {
			 return null;
			 //return entityManager.createQuery( "update Department set departmentName=", Department.class ).getSingleResult();
		}
	    
	    
}
