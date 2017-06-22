package zjzt.action;

import java.util.List;
import java.util.Map;

import zjzt.entity.News;
import zjzt.entity.Product;
import zjzt.entity.Project;
import zjzt.service.INewsService;
import zjzt.service.IProductService;
import zjzt.service.IProjectService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class IndexAction extends ActionSupport {

	private IProductService productService;
	private IProjectService projectService;
	private INewsService newsService;

	public IProductService getProductService() {
		return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	public IProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(IProjectService projectService) {
		this.projectService = projectService;
	}

	public INewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(INewsService newsService) {
		this.newsService = newsService;
	}

	/**
	 * 获取所有的项目和产品列表
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String index() {
		List<Product> productList = productService.getAllProducts();
		List<Project> projectList = projectService.getAllProject();
		List<News> newsList = newsService.getAllNews();
		Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		request.put("productList", productList);
		request.put("projectList", projectList);
		request.put("newsList", newsList);
		return SUCCESS;
	}
}
