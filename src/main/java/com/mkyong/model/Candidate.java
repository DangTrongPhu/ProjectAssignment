package com.mkyong.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Candidate")
public class Candidate implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "id_user")
	private String id_user;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "gpa")
	private Double gpa;
	
	@Column(name = "graduationyear")
	private Integer graduationyear;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "university")
	private String 	university;
	
	@Column(name = "interviewdate")
	private Date interviewdate;
	
	@Column(name = "iqtest")
	private Integer iqtest;
	
	@Column(name = "technicaltest")
	private Integer technicaltest;
	
	@Column(name = "toeic")
	private Integer toeic;
	
	@Column(name = "interviewresult")
	private String interviewresult;
	
	@Column(name = "interviewcomments")
	private String interviewcomments;
	
	@Column(name = "dayofbirth")
	private Date dayofbirth;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "address")
	private String address;

	@Column(name = "degree")
	private String degree;
	
	@Column(name = "notes")
	private String notes;

	public Candidate() {

	}

	public Candidate(String id_user, String fullname, Double gpa, Integer graduationyear, String position,
			String university, Date interviewdate, Integer iqtest, Integer technicaltest, Integer toeic,
			String interviewresult, String interviewcomments, Date dayofbirth, String email, String phone,
			String address, String degree, String notes) {
		this.id_user = id_user;
		this.fullname = fullname;
		this.gpa = gpa;
		this.graduationyear = graduationyear;
		this.position = position;
		this.university = university;
		this.interviewdate = interviewdate;
		this.iqtest = iqtest;
		this.technicaltest = technicaltest;
		this.toeic = toeic;
		this.interviewresult = interviewresult;
		this.interviewcomments = interviewcomments;
		this.dayofbirth = dayofbirth;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.degree = degree;
		this.notes = notes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	public Integer getGraduationyear() {
		return graduationyear;
	}

	public void setGraduationyear(Integer graduationyear) {
		this.graduationyear = graduationyear;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public Date getInterviewdate() {
		return interviewdate;
	}

	public void setInterviewdate(Date interviewdate) {
		this.interviewdate = interviewdate;
	}

	public Integer getIqtest() {
		return iqtest;
	}

	public void setIqtest(Integer iqtest) {
		this.iqtest = iqtest;
	}

	public Integer getTechnicaltest() {
		return technicaltest;
	}

	public void setTechnicaltest(Integer technicaltest) {
		this.technicaltest = technicaltest;
	}

	public Integer getToeic() {
		return toeic;
	}

	public void setToeic(Integer toeic) {
		this.toeic = toeic;
	}

	public String getInterviewresult() {
		return interviewresult;
	}

	public void setInterviewresult(String interviewresult) {
		this.interviewresult = interviewresult;
	}

	public String getInterviewcomments() {
		return interviewcomments;
	}

	public void setInterviewcomments(String interviewcomments) {
		this.interviewcomments = interviewcomments;
	}

	public Date getDayofbirth() {
		return dayofbirth;
	}

	public void setDayofbirth(Date dayofbirth) {
		this.dayofbirth = dayofbirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", id_user=" + id_user + ", fullname=" + fullname + ", gpa=" + gpa
				+ ", graduationyear=" + graduationyear + ", position=" + position + ", university=" + university
				+ ", interviewdate=" + interviewdate + ", iqtest=" + iqtest + ", technicaltest=" + technicaltest
				+ ", toeic=" + toeic + ", interviewresult=" + interviewresult + ", interviewcomments="
				+ interviewcomments + ", dayofbirth=" + dayofbirth + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + ", degree=" + degree + ", notes=" + notes + "]";
	}
	
	
	
}
