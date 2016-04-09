package gapp.model;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "education_info")
public class EducationInfo implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name="education_id")
    private Integer id;
    
    @Column(name="college_name")
    private String collegeName;
    
    private String duration;
    
    @Column(name="degree_earned")
    private String degreeEarned;
    
    private String major;
    
    @ManyToOne
    private Student student;
    
    @ManyToOne
    private Application application;
    
    private boolean isValid;
    
    
    public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

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
	
	

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDegreeEarned() {
		return degreeEarned;
	}

	public void setDegreeEarned(String degreeEarned) {
		this.degreeEarned = degreeEarned;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	  
    
}
