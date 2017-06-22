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
	 * 获取产品服务的详细
	 */
	public Product getProductById(int id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}
	/**
	 * 增加产品信息
	 */
	@Transactional
	public boolean addProduct(Product product) {
		 Session session=sessionFactory.getCurrentSession();
		 session.save(product);
		return true;
	}
	/**
	 * 更新产品
	 */
	@Transactional
	public boolean updateProduct(Product product) {
		 Session session=sessionFactory.getCurrentSession();
		 session.update(product);
		return true;
	}
	/**
	 * 删除产品
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
