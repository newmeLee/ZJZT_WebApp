package zjzt.service;

import java.util.List;

import zjzt.entity.News;

public interface INewsService {
	/**
	 * 获取所有的通知
	 * @return
	 */
	List<News> getAllNews();
	/**
	 * 根据ID获取新闻信息
	 * @param id
	 * @return
	 */
	News getNewsById(int id);
	/**
	 * 新增新闻信息
	 * @param news
	 * @return
	 */
	boolean addNews(News news);
	/**
	 * 更新新闻信息
	 * @param news
	 * @return
	 */
	boolean updateNews(News news);
}
