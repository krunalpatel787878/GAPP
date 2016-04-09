package gapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name="student_id")
    private Integer id;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="first_name")
    private String firstName;

    
    @Column(name="cin" ,nullable=true)
    private String CIN;
    
    private String phone;
    
    private String email;
    
    private boolean international;
    
    private String gender;
    
    @OneToMany(mappedBy="student")
    private Set<EducationInfo> info;
    
    @Column(name="date_of_birth")
    private Date DOB;
    
   
    
    private String citizenship;

   
    
    @OneToOne
    private User user;

	
	
	private boolean isValid;
	
	
    
    
    public boolean isInternational() {
		return international;
	}

	public void setInternational(boolean international) {
		this.international = international;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
    
    
	
	public Set<EducationInfo> getInfo() {
		return info;
	}

	public void setInfo(Set<EducationInfo> info) {
		this.info = info;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}
    
    
}
