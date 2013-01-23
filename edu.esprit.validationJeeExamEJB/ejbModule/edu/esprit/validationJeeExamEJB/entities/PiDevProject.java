package edu.esprit.validationJeeExamEJB.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Project
 * 
 */
@Entity
public class PiDevProject implements Serializable {

	private int idProject;
	private String nameProject;

	private List<Student> students;
	private static final long serialVersionUID = 1L;

	public PiDevProject() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdProject() {
		return this.idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public String getNameProject() {
		return this.nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}

	@OneToMany(mappedBy = "piDevProject", cascade = CascadeType.ALL)
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void linkStudentsToPiDevProject(List<Student> students) {
		for (Student s : students) {
			s.setPiDevProject(this);
		}
		this.students = students;
	}

}
