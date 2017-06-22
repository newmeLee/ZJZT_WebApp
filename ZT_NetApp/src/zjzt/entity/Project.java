package zjzt.entity;
/**
 * 工程项目实体类
 * @author Administrator
 *
 */
public class Project {
	private int id;
	private String projectName;
	private String customeName;
	private String projectContent;
	private String picUrl1;
	private String picUrl2;
	private String picUrl3;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCustomeName() {
		return customeName;
	}
	public void setCustomeName(String customeName) {
		this.customeName = customeName;
	}
	public String getProjectContent() {
		return projectContent;
	}
	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
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
	
}
