package zjzt.dao;

import java.util.List;

import zjzt.entity.Feedback;

public interface IFeedbackDao {
	/**
	 * ����һ��������Ϣ
	 * @return
	 */
	boolean addFeedback(Feedback feedback);
	/**
	 * ��ȡ���еķ�����Ϣ
	 * @return
	 */
	List<Feedback> getAllFeedback();
	/**
	 * ����ID��ȡ��Ӧ�ķ�����Ϣ
	 * @param id
	 * @return
	 */
	Feedback getFeedbackById(int id);
}
