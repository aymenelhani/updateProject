package edu.esprit.validationJeeExamEJB.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.validationJeeExamEJB.entities.PiDevProject;
import edu.esprit.validationJeeExamEJB.entities.Student;

@Local
public interface ApplicationManagementLocal {
	void addPiDevProject(PiDevProject piDevProject);

	void deletePiDevProject(int idPiDevProject);

	void updatePiDevProject(PiDevProject piDevProject);

	PiDevProject finfPiDevProjectById(int idPiDevProject);

	List<PiDevProject> findAllPiDevProject();

	void addStudent(Student student);

	List<Student> findAllStudent();
}
