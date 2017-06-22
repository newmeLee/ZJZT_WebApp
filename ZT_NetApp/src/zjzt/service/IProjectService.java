package zjzt.service;

import java.util.List;

import zjzt.entity.Project;

public interface IProjectService {
	/**
	 * ��ȡ���е�ҵ����Ŀ
	 * @return
	 */
	List<Project> getAllProject();
	/**
	 * ����������ȡ��Ŀ��Ϣ
	 * @param id
	 * @return
	 */
	Project getProjectById(int id);
	/**
	 * ������Ŀ��Ϣ
	 * @param project
	 * @return
	 */
	boolean addProject(Project project);
	/**
	 * ������Ŀ��Ϣ
	 * @param project
	 * @return
	 */
	boolean updateProject(Project project);
	/**
	 * ɾ����Ŀ��Ϣ
	 * @param project
	 * @return
	 */
	boolean deleteProject(Project project);
}
