package zjzt.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import zjzt.dao.IProjectDao;
import zjzt.entity.Project;

public class ProjectDao implements IProjectDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Project> getAllProject() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Project")
				.list();
	}

	public Project getProjectById(int id) {
		// TODO Auto-generated method stub
		return (Project) sessionFactory.getCurrentSession().get(Project.class,
				id);
	}
	@Transactional
	public boolean updateProject(Project project) {
		Session session=sessionFactory.getCurrentSession();
		 session.update(project);
		return true;
	}
	@Transactional
	public boolean deleteProject(Project project) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(project);
		return true;
	}
	@Transactional
	public boolean addProject(Project project) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(project);
		return true;
	}

}
