package gapp.model.dao;

import java.util.List;

import gapp.model.ApplicationStatus;


public interface ApplicationStatusDao {

	List<ApplicationStatus> getStatus();
	
	ApplicationStatus getStatus(int id);
}
