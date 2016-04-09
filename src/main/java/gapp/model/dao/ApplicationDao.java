package gapp.model.dao;

import java.util.List;

import gapp.model.Application;
import gapp.model.Student;
import gapp.model.User;


public interface ApplicationDao {

	 List<Application> getApplications();
	 
	Application getApplicationsById(int id);
	 
	 List<Application> getApplication( String dept , String term );
	 
	 List<Application> getApplicationByStudent(int id);
	 
	 List<Application> getApplicationByStatus(String status);
	 
	 Application saveApplication( Application app );
	 
	 Student getStudent(int appid);
}
