package gapp.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

public class DepartmentDaoTest  {
	@Test(groups = "DepartmentDaoTest")
	@ContextConfiguration(locations = "classpath:applicationContext.xml")
	public class DepartmentDaoTests extends AbstractTransactionalTestNGSpringContextTests {

	    @Autowired
	    DepartmentDao departmentDao;

	    /* There is two departments */
	    @Test
	    public void getDepartments()
	    {
	        assert departmentDao.getDepartments().size() >0;
	    }
	}
}
