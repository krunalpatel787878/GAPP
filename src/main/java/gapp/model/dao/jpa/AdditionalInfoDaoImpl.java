package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.AdditionalInfo;
import gapp.model.DepartmentMajor;
import gapp.model.dao.AdditionalInfoDao;
import gapp.model.dao.UserDao;

@Repository
public class AdditionalInfoDaoImpl implements AdditionalInfoDao {
	 @PersistenceContext
	    private EntityManager entityManager;

	@Override
	public List<AdditionalInfo> getInfo(int id) {
		return entityManager.createQuery( "from AdditionalInfo where isValid='true' and department.id= :id", AdditionalInfo.class )
    			.setParameter( "id", id )
    			.getResultList();
		
	}

	@Transactional
    @Override
	public AdditionalInfo saveInfo(AdditionalInfo info) {
		return entityManager.merge( info );
	}

	@Override
	@Transactional
	public Integer removeInfo(int id) {
		String query = "update from AdditionalInfo set  isValid='false' where  id= :id";
		Query q = entityManager.createQuery(query);
		
		q.setParameter("id", id);
		int r = q.executeUpdate();
		return r;
	}

	@Override
	public AdditionalInfo getInfoByDept(int id) {
		return entityManager.createQuery( "from AdditionalInfo where isValid='true' and id= :id", AdditionalInfo.class )
    			.setParameter( "id", id )
    			.getSingleResult();
	}

	@Override
	public List<AdditionalInfo> getInfoBtdepartment(int dept) {
		// TODO Auto-generated method stub
		return null;
	}
}
