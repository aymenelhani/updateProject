package edu.esprit.validationJeeExamWeb.ctr;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import edu.esprit.validationJeeExamEJB.entities.PiDevProject;
import edu.esprit.validationJeeExamEJB.entities.Student;
import edu.esprit.validationJeeExamEJB.services.interfaces.ApplicationManagementLocal;

@ManagedBean
@SessionScoped
public class ManagementCtr {
	// modeles
	private Student student = new Student();
	private PiDevProject piDevProject = new PiDevProject();
	private DataModel<PiDevProject> dataModel = new ListDataModel<PiDevProject>();
	
	private PiDevProject editPidDevProject;

	// dependency injection
	@EJB
	private ApplicationManagementLocal applicationManagementLocal;

	// methods
	
	
	public String doUpdatePiDev(){
		
		applicationManagementLocal.updatePiDevProject(editPidDevProject);
		return "";
	}
	
	public String doRedirectUpdatePiDev(){
		
		editPidDevProject = (PiDevProject) dataModel.getRowData();
		System.out.println("redirect");
		return "edit";
		
	}
	
	
	public String doAddPiDevProject() {
		applicationManagementLocal.addPiDevProject(piDevProject);
		return "";
	}

	public String doAddStudent() {
		student.setPiDevProject((PiDevProject)dataModel.getRowData());
		applicationManagementLocal.addStudent(student);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Welcome "));  
		return "";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public PiDevProject getPiDevProject() {
		return piDevProject;
	}

	public void setPiDevProject(PiDevProject piDevProject) {
		this.piDevProject = piDevProject;
	}

	public DataModel<PiDevProject> getDataModel() {
		dataModel.setWrappedData(applicationManagementLocal
				.findAllPiDevProject());
		return dataModel;
	}

	public void setDataModel(DataModel<PiDevProject> dataModel) {
		this.dataModel = dataModel;
	}

	public PiDevProject getEditPidDevProject() {
		return editPidDevProject;
	}

	public void setEditPidDevProject(PiDevProject editPidDevProject) {
		this.editPidDevProject = editPidDevProject;
	}
	
	

}
