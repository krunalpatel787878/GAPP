package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import gapp.model.ApplicationStatus;
import gapp.model.User;
import gapp.model.dao.ApplicationStatusDao;

@Repository
public class ApplicationStatusDaoImpl implements ApplicationStatusDao {
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
    public List<ApplicationStatus> getStatus()
    {
        return entityManager.createQuery( "from ApplicationStatus where  isValid='true' order by id ", ApplicationStatus.class ).getResultList();
    }

	@Override
	public ApplicationStatus getStatus(int id) {
		return entityManager.find( ApplicationStatus.class, id );
	}
	
}
