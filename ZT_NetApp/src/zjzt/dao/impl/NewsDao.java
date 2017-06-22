package zjzt.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import zjzt.dao.INewsDao;
import zjzt.entity.News;

public class NewsDao implements INewsDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from News")
				.list();
	}

	public News getNewsById(int id) {
		// TODO Auto-generated method stub
		return (News) sessionFactory.getCurrentSession().get(News.class, id);
	}

	@Transactional
	public boolean addNews(News news) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(news);
		return true;
	}
	@Transactional
	public boolean updateNews(News news) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(news);
		return true;
	}

}
