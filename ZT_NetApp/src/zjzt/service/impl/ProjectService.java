package zjzt.service.impl;

import java.util.List;

import zjzt.dao.IProjectDao;
import zjzt.entity.Project;
import zjzt.service.IProjectService;

public class ProjectService implements IProjectService {

	private IProjectDao projectDao;
	public IProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(IProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public List<Project> getAllProject() {
		// TODO Auto-generated method stub
		return projectDao.getAllProject();
	}

	public Project getProjectById(int id) {
		// TODO Auto-generated method stub
		return projectDao.getProjectById(id);
	}

	public boolean updateProject(Project project) {
		// TODO Auto-generated method stub
		return projectDao.updateProject(project);
	}

	public boolean deleteProject(Project project) {
		// TODO Auto-generated method stub
		return projectDao.deleteProject(project);
	}

	public boolean addProject(Project project) {
		// TODO Auto-generated method stub
		return projectDao.addProject(project);
	}

}
