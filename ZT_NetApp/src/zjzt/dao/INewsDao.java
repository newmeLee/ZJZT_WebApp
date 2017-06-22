package zjzt.dao;

import java.util.List;

import zjzt.entity.News;

public interface INewsDao {
	/**
	 * ��ȡ���е�֪ͨ
	 * @return
	 */
	List<News> getAllNews();
	/**
	 * ����ID��ȡ������Ϣ
	 * @param id
	 * @return
	 */
	News getNewsById(int id);
	/**
	 * ����������Ϣ
	 * @param news
	 * @return
	 */
	boolean addNews(News news);
	/**
	 * ����������Ϣ
	 * @param news
	 * @return
	 */
	boolean updateNews(News news);
}
