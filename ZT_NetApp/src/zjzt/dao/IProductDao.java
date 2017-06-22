package zjzt.dao;

import java.util.List;

import zjzt.entity.Product;

/**
 * ��˾��Ʒģ��Dao�ӿ����
 * @author Administrator
 *
 */
public interface IProductDao {
	/**
	 * ��ȡ���еĲ�Ʒ
	 * @return
	 */
	List<Product> getAllProduct();
	/**
	 * ��ȡ��Ʒ��ϸ
	 * @return
	 */
	Product getProductById(int id);
	/**
	 * ������Ʒ
	 * @param product
	 * @return
	 */
	boolean addProduct(Product product);
	/**
	 * ���²�Ʒ��Ϣ
	 * @param product
	 * @return
	 */
	boolean updateProduct(Product product);
	/**
	 * ɾ����Ʒ
	 * @param product
	 * @return
	 */
	boolean deleteProduct(Product product);
}
