package zjzt.service;

import java.util.List;

import zjzt.entity.Product;

/**
 * 产品Service模块接口设计
 * @author Administrator
 *
 */
public interface IProductService {
	/**
	 * 获取所有的产品
	 * @return
	 */
	List<Product> getAllProducts();
	/**
	 * 获取产品服务的详细
	 * @param id
	 * @return
	 */
	Product getProductById(int id);
	/**
	 * 新增产品服务信息
	 * @param product
	 * @return
	 */
	boolean addProduct(Product product);
	/**
	 * 更新产品信息
	 * @param product
	 * @return
	 */
	boolean updateProduct(Product product);
	/**
	 * 删除产品
	 * @param product
	 * @return
	 */
	boolean deleteProduct(Product product);
}
