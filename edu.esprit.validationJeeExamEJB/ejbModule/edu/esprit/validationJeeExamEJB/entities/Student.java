package edu.esprit.validationJeeExamEJB.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Student
 * 
 */
@Entity
public class Student implements Serializable {

	private int idStudent;
	private String nameStudent;
	private Date dateOfAffectation;
	private String emailStudent;

	private PiDevProject piDevProject;
	private static final long serialVersionUID = 1L;

	public Student() {
		super();
	}

	@Id
	public int getIdStudent() {
		return this.idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public String getNameStudent() {
		return this.nameStudent;
	}

	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	@ManyToOne
	public PiDevProject getPiDevProject() {
		return piDevProject;
	}

	public void setPiDevProject(PiDevProject piDevProject) {
		this.piDevProject = piDevProject;
	}

	public Date getDateOfAffectation() {
		return dateOfAffectation;
	}

	public void setDateOfAffectation(Date dateOfAffectation) {
		this.dateOfAffectation = dateOfAffectation;
	}

	public String getEmailStudent() {
		return emailStudent;
	}

	public void setEmailStudent(String emailStudent) {
		this.emailStudent = emailStudent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
