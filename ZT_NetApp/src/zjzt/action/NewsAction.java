package zjzt.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import zjzt.entity.News;
import zjzt.service.INewsService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("all")
public class NewsAction extends ActionSupport {

	private int id;
	private String title;
	private String keyword;
	private String content;
	private News result;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public News getResult() {
		return result;
	}

	public void setResult(News result) {
		this.result = result;
	}

	private INewsService newsService;

	public void setNewsService(INewsService newsService) {
		this.newsService = newsService;
	}

	/**
	 * 获取所有的新闻
	 * 
	 * @return
	 */
	public String getAllNews() {
		List<News> newsList = newsService.getAllNews();
		Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		request.put("newsList", newsList);
		return SUCCESS;
	}

	/**
	 * 根据ID获取新闻
	 * 
	 * @return
	 */
	public String getNewsById() {
		News news = newsService.getNewsById(id);
		Map<String, Object> request = (Map<String, Object>) ActionContext
				.getContext().get("request");
		request.put("news", news);
		return SUCCESS;
	}

	/**
	 * 根据ID获取新闻(Json格式)
	 * 
	 * @return
	 */
	public String getJsonNewsById() {
		this.setResult(newsService.getNewsById(id));
		return SUCCESS;
	}

	/**
	 * 新增或更新新闻信息
	 * 
	 * @return
	 */
	public String saveOrUpdateNews() {
		News news = new News();
		news.setTitle(title);
		news.setKeyword(keyword);
		news.setContent(content);
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		news.setGmtCreate(dateFormat.format(new Date()));
		news.setGmtModified(dateFormat.format(new Date()));
		news.setCreater("admin");
		if (this.getId() < 1) {
			// 不存在id时
			newsService.addNews(news);
		} else {
			news.setId(id);
			newsService.updateNews(news);
		}
		return SUCCESS;
	}
}
