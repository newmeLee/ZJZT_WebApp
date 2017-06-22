package zjzt.service.impl;

import java.util.List;

import zjzt.dao.IFeedbackDao;
import zjzt.entity.Feedback;
import zjzt.service.IFeedbackService;

public class FeedbackService implements IFeedbackService {

	private IFeedbackDao feedbackDao;

	public void setFeedbackDao(IFeedbackDao feedbackDao) {
		this.feedbackDao = feedbackDao;
	}

	public boolean addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return feedbackDao.addFeedback(feedback);
	}

	public List<Feedback> getAllFeedback() {
		// TODO Auto-generated method stub
		return feedbackDao.getAllFeedback();
	}

	public Feedback getFeedbackById(int id) {
		// TODO Auto-generated method stub
		return feedbackDao.getFeedbackById(id);
	}

}
