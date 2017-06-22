package zjzt.dao;

import java.util.List;

import zjzt.entity.Feedback;

public interface IFeedbackDao {
	/**
	 * 增加一条反馈信息
	 * @return
	 */
	boolean addFeedback(Feedback feedback);
	/**
	 * 获取所有的反馈信息
	 * @return
	 */
	List<Feedback> getAllFeedback();
	/**
	 * 根据ID获取相应的反馈信息
	 * @param id
	 * @return
	 */
	Feedback getFeedbackById(int id);
}
