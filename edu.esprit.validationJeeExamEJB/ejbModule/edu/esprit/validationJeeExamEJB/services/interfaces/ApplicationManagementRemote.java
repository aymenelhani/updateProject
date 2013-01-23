package edu.esprit.validationJeeExamEJB.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.validationJeeExamEJB.entities.PiDevProject;

@Remote
public interface ApplicationManagementRemote {

	void addPiDevProject(PiDevProject piDevProject);

	void deletePiDevProject(int idPiDevProject);

	void updatePiDevProject(PiDevProject piDevProject);

	PiDevProject finfPiDevProjectById(int idPiDevProject);

	List<PiDevProject> findAllPiDevProject();
}
