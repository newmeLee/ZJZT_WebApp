package zjzt.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import zjzt.dao.IProductDao;
import zjzt.entity.Product;

public class ProductDao implements IProductDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProduct() {
		return sessionFactory.getCurrentSession().createQuery("from Product order by orderNo")
				.list();
	}
	/**
	 * ��ȡ��Ʒ�������ϸ
	 */
	public Product getProductById(int id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}
	/**
	 * ���Ӳ�Ʒ��Ϣ
	 */
	@Transactional
	public boolean addProduct(Product product) {
		 Session session=sessionFactory.getCurrentSession();
		 session.save(product);
		return true;
	}
	/**
	 * ���²�Ʒ
	 */
	@Transactional
	public boolean updateProduct(Product product) {
		 Session session=sessionFactory.getCurrentSession();
		 session.update(product);
		return true;
	}
	/**
	 * ɾ����Ʒ
	 * @param product
	 * @return
	 */
	@Transactional
	public boolean deleteProduct(Product product){
		Session session=sessionFactory.getCurrentSession();
		session.delete(product);
		return true;
	}
}
