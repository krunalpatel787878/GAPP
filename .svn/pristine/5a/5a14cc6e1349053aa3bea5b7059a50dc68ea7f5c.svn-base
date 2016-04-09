package gapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "applications")
public class Application implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name="application_id")
    private Integer id;
    
    @OneToOne
    private DepartmentMajor program;
    
    private String term;
    
    @ManyToOne
    private Student student;
    
    @OneToMany(mappedBy="application")
    private List<EducationInfo> info;
    
    @OneToOne
    private ApplicationStatus status;
    
    private Date createdOn;
    
    private boolean isSubmited;
    
    @Column(name="toefl",nullable=true)
    private Integer TOEFL;
    
    private String transcript;
    
    @Column(name="gpa")
    private double GPA;
    
    private boolean isValid;
    
    
    
  
    public List<EducationInfo> getInfo() {
		return info;
	}

	public void setInfo(List<EducationInfo> info) {
		this.info = info;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public boolean isSubmited() {
		return isSubmited;
	}

	public void setSubmited(boolean isSubmited) {
		this.isSubmited = isSubmited;
	}

	public Integer getTOEFL() {
		return TOEFL;
	}

	public void setTOEFL(Integer tOEFL) {
		TOEFL = tOEFL;
	}

	public String getTranscript() {
		return transcript;
	}

	public void setTranscript(String transcript) {
		this.transcript = transcript;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
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

	public DepartmentMajor getProgram() {
		return program;
	}

	public void setProgram(DepartmentMajor program) {
		this.program = program;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public ApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}

	
    
    
    
    
}
