package gapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name="department_id")
    private Integer id;
    
    @Column(name="department_name")
    private String departmentName;
    
    @OneToMany(mappedBy="department")
    List<DepartmentMajor> major;
    
private boolean isValid;
    
    
    public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
    
    

}
