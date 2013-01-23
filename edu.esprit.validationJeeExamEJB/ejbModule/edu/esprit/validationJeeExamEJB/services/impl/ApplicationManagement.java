package edu.esprit.validationJeeExamEJB.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.validationJeeExamEJB.entities.PiDevProject;
import edu.esprit.validationJeeExamEJB.entities.Student;
import edu.esprit.validationJeeExamEJB.services.interfaces.ApplicationManagementLocal;
import edu.esprit.validationJeeExamEJB.services.interfaces.ApplicationManagementRemote;

/**
 * Session Bean implementation class ApplicationManagement
 */
@Stateless
public class ApplicationManagement implements ApplicationManagementRemote,
		ApplicationManagementLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ApplicationManagement() {

	}

	@Override
	public void addPiDevProject(PiDevProject piDevProject) {
		entityManager.persist(piDevProject);

	}

	@Override
	public void deletePiDevProject(int idPiDevProject) {
		entityManager.remove(finfPiDevProjectById(idPiDevProject));

	}

	@Override
	public void updatePiDevProject(PiDevProject piDevProject) {
		entityManager.merge(piDevProject);

	}

	@Override
	public PiDevProject finfPiDevProjectById(int idPiDevProject) {

		return entityManager.find(PiDevProject.class, idPiDevProject);
	}

	@Override
	public List<PiDevProject> findAllPiDevProject() {

		String jpql = "select p from PiDevProject p";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public void addStudent(Student student) {
		entityManager.persist(student);
		
	}

	@Override
	public List<Student> findAllStudent() {
		
		String jpql="select s from Student s";
		return entityManager.createQuery(jpql).getResultList();
	}

}
