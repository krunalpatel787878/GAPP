package gapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "additional_record")
public class AdditionRecord  implements Serializable  {

	private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue
    @Column(name="record_id")
    private Integer id;
    
    private String value;
    
private boolean isValid;

@ManyToOne
private AdditionalInfo info;
    
    @ManyToOne
    private Student student;
    
    @ManyToOne
    private Application application;
    
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public AdditionalInfo getInfo() {
		return info;
	}

	public void setInfo(AdditionalInfo info) {
		this.info = info;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
    
    
    
}
