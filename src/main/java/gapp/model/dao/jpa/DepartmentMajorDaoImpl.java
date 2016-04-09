package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Department;
import gapp.model.DepartmentMajor;
import gapp.model.dao.DepartmentMajorDao;

@Repository
public class DepartmentMajorDaoImpl implements DepartmentMajorDao {
	
	 @PersistenceContext
	    private EntityManager entityManager;
	 
	 @Override
		public List<DepartmentMajor> getMajor(int id) {
			return entityManager.createQuery( "from DepartmentMajor where  isValid='true' and  department.id= :id", DepartmentMajor.class )
	    			.setParameter( "id", id )
	    			.getResultList();
		}
	 
	

	@Override
		public List<Object[]> getNumberMajor() {
			
		 return  entityManager.createQuery( "select d.id,count(p.id) as count from  Department d left join d.major p with p.isValid=true where d.isValid=true GROUP BY d.id",Object[].class)
	    			.getResultList();
			
			
		}
		
		 @Transactional
		    @Override
		public DepartmentMajor saveDepartmentMajor(DepartmentMajor departmentMajor) {
			 return entityManager.merge( departmentMajor );
		}



		@Override
		@Transactional
		public Integer removeMajor(int id) {
			
			String query = "update from DepartmentMajor set  isValid='false' where  id= :id";
			Query q = entityManager.createQuery(query);
			
			q.setParameter("id", id);
			int r = q.executeUpdate();
			return r;
			
		}



		@Override
		public DepartmentMajor getMajorByDept(int id) {
			return entityManager.createQuery( "from DepartmentMajor where  isValid='true' and  id= :id", DepartmentMajor.class )
	    			.setParameter( "id", id )
	    			.getSingleResult();
		}



		@Override
		public List<DepartmentMajor> getProgrambyAjax(int id) {
			return entityManager.createQuery( "from DepartmentMajor where  isValid='true' and  department.id= :id", DepartmentMajor.class )
	    			.setParameter( "id", id )
	    			.getResultList();
		}



		@Override
		public DepartmentMajor getDepartmentMajor(int id) {
			return entityManager.find(DepartmentMajor.class, id);
		}

}
