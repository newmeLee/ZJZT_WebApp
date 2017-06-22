package zjzt.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import zjzt.dao.IFeedbackDao;
import zjzt.entity.Feedback;
import zjzt.entity.News;

@SuppressWarnings("all")
public class FeedbackDao implements IFeedbackDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public boolean addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(feedback);
		return true;
	}

	public List<Feedback> getAllFeedback() {
		return sessionFactory.getCurrentSession().createQuery("from Feedback")
				.list();
	}

	public Feedback getFeedbackById(int id) {
		return (Feedback) sessionFactory.getCurrentSession().get(
				Feedback.class, id);
	}

}
