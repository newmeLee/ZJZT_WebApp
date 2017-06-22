package zjzt.service;

import java.util.List;

import zjzt.entity.Product;

/**
 * ��ƷServiceģ��ӿ����
 * @author Administrator
 *
 */
public interface IProductService {
	/**
	 * ��ȡ���еĲ�Ʒ
	 * @return
	 */
	List<Product> getAllProducts();
	/**
	 * ��ȡ��Ʒ�������ϸ
	 * @param id
	 * @return
	 */
	Product getProductById(int id);
	/**
	 * ������Ʒ������Ϣ
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
