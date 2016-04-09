package gapp.model.dao;

import java.util.List;

import gapp.model.Department;
import gapp.model.User;

public interface DepartmentDao {
	
	  List<Department> getDepartments();
	  
	  List<Department> getmajorNumbers();
	  
	  Department getDepartment(int id);
	  
	  Department saveDepartment( Department department );
	  
	  Department editDepartment(int id);
	  
	  
}
