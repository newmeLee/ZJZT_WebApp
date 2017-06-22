package zjzt.service.impl;

import java.util.List;

import zjzt.dao.INewsDao;
import zjzt.entity.News;
import zjzt.service.INewsService;

public class NewsService implements INewsService {

	private INewsDao newsDao;
	public void setNewsDao(INewsDao newsDao) {
		this.newsDao = newsDao;
	}

	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		return newsDao.getAllNews();
	}

	public News getNewsById(int id) {
		// TODO Auto-generated method stub
		return newsDao.getNewsById(id);
	}

	public boolean addNews(News news) {
		// TODO Auto-generated method stub
		return newsDao.addNews(news);
	}

	public boolean updateNews(News news) {
		// TODO Auto-generated method stub
		return newsDao.updateNews(news);
	}

}
