package zjzt.action;

import java.util.List;
import java.util.Map;

import zjzt.entity.Product;
import zjzt.entity.Project;
import zjzt.service.IProjectService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ProjectAction extends ActionSupport{
	private int id;
	private String name;
	private String customer;
	private String content;
	private String picUrl1;
	private String picUrl2;
	private String picUrl3;
	private String result;
	private Project project;
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicUrl1() {
		return picUrl1;
	}
	public void setPicUrl1(String picUrl1) {
		this.picUrl1 = picUrl1;
	}
	public String getPicUrl2() {
		return picUrl2;
	}
	public void setPicUrl2(String picUrl2) {
		this.picUrl2 = picUrl2;
	}
	public String getPicUrl3() {
		return picUrl3;
	}
	public void setPicUrl3(String picUrl3) {
		this.picUrl3 = picUrl3;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	private IProjectService projectService;
	public void setProjectService(IProjectService projectService) {
		this.projectService = projectService;
	}
	/**
	 * 获取所有的项目信息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getAllProject(){
		List<Project> projectList=projectService.getAllProject();
		Map<String, Object> request=(Map<String, Object>) ActionContext.getContext().get("request");
		request.put("projectList", projectList);
		return SUCCESS;
	}
	/**
	 * 根据ID获取项目信息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getProjectById(){
		Project project =projectService.getProjectById(id);
		Map<String, Object> request=(Map<String, Object>) ActionContext.getContext().get("request");
		request.put("project", project);
		return SUCCESS;
	}
	/**
	 * 新增或更新项目信息
	 * @return
	 */
	public String addOrUpdateProject(){
		Project project=new Project();
		project.setProjectName(name);
		project.setCustomeName(customer);
		project.setProjectContent(content);
		project.setPicUrl1(picUrl1);
		project.setPicUrl2(picUrl2);
		project.setPicUrl3(picUrl3);
		if(getId()<0){
			//新增
			projectService.addProject(project);
		}else{
			//更新
			project.setId(id);
			projectService.updateProject(project);
		}
		this.setResult("200");
		return SUCCESS;
	}
	/**
	 * 获取项目的详细(后台Json数据)
	 * @return
	 */
	@SuppressWarnings("all")
	public String getJsonProjectById(){
		this.setProject(projectService.getProjectById(id)) ;
		return SUCCESS;
	}
	
	/**
	 * 删除项目信息
	 * @return
	 */
	public String deleteProject(){
		if(getId()>0){
			Project project= projectService.getProjectById(id);
			projectService.deleteProject(project);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
}
