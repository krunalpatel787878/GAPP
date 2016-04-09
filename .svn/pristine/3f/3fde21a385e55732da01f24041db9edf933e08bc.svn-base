package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.EducationInfo;
import gapp.model.dao.EducationInfoDao;

@Repository
public class EducationInfoDaoImpl implements EducationInfoDao {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<EducationInfo> getEducationInfo(String email) {
		return entityManager.createQuery( "from EducationInfo where  isValid='true' and  student.email= :email", EducationInfo.class )
    			.setParameter( "email", email )
    			.getResultList();
	}

	@Override
	public List<EducationInfo> getEducationInfoByApplicationid(int id) {
		return entityManager.createQuery( "from EducationInfo where  isValid='true' and  application.id= :id", EducationInfo.class )
    			.setParameter( "id", id )
    			.getResultList();
	}

	 @Transactional
	@Override
	public EducationInfo saveInfo(EducationInfo info) {
		return entityManager.merge( info );
	}

	@Override
	public EducationInfo get(int id) {
		
		return entityManager.find(EducationInfo.class, id);
	}
}
