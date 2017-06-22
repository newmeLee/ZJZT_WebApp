package zjzt.dao;

import java.util.List;

import zjzt.entity.Project;

/**
 * ҵ����ĿDao�ӿ���
 * @author Administrator
 *
 */
public interface IProjectDao {
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
	 * ������Ŀ
	 * @param product
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
