package gapp.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;


public class ApplicationDaoTest {
		@Test(groups = "ApplicationDaoTest")
		@ContextConfiguration(locations = "classpath:applicationContext.xml")
		public class ApplicationTests extends AbstractTransactionalTestNGSpringContextTests {

		    @Autowired
		    ApplicationDao applicationDao;

		    /* For the Accounting Department, there is one application for Fall 2016  */
		    
		    @Test
		    public void getApplication()
		    {
		        assert applicationDao.getApplication("Accounting", "Fall 2016").size()==1;
		    }

		   
		    /* student1 submitted one application */
		    
		    @Test
		    public void getApplicationByStudent()
		    {
		        //assert applicationDao.getApplicationByStudent("student1@localhost.localdomain").size()==1;
		    }
		    
		   

		}
}
