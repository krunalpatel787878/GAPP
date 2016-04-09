package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.AdditionRecord;
import gapp.model.AdditionalInfo;
import gapp.model.User;
import gapp.model.dao.AdditionRecordDao;

@Repository
public class AdditionRecordDaoImpl implements AdditionRecordDao {
	 @PersistenceContext
	    private EntityManager entityManager;

	@Override
	public List<AdditionRecord> getrecord(int id) {
		return entityManager.createQuery( "from AdditionRecord where isValid='true' and application.id= :id", AdditionRecord.class )
    			.setParameter( "id", id )
    			.getResultList();
	}

	@Transactional
	@Override
	public AdditionRecord saveRecord(AdditionRecord record) {
		// TODO Auto-generated method stub
		 return entityManager.merge( record );
	}

	@Override
	public AdditionRecord getRecord(Integer id) {
		return entityManager.find( AdditionRecord.class, id );
	}
}
