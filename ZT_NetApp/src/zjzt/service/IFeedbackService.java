package zjzt.service;

import java.util.List;

import zjzt.entity.Feedback;

public interface IFeedbackService {
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
