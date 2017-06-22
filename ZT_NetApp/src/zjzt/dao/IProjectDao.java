package zjzt.dao;

import java.util.List;

import zjzt.entity.Project;

/**
 * 业务项目Dao接口类
 * @author Administrator
 *
 */
public interface IProjectDao {
	/**
	 * 获取所有的业务项目
	 * @return
	 */
	List<Project> getAllProject();
	/**
	 * 根据主键获取项目信息
	 * @param id
	 * @return
	 */
	Project getProjectById(int id);
	/**
	 * 新增项目
	 * @param product
	 * @return
	 */
	boolean addProject(Project project);
	/**
	 * 更新项目信息
	 * @param project
	 * @return
	 */
	boolean updateProject(Project project);
	/**
	 * 删除项目信息
	 * @param project
	 * @return
	 */
	boolean deleteProject(Project project);
}
