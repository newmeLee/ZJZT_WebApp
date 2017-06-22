package zjzt.dao;

import java.util.List;

import zjzt.entity.Product;

/**
 * 公司产品模块Dao接口设计
 * @author Administrator
 *
 */
public interface IProductDao {
	/**
	 * 获取所有的产品
	 * @return
	 */
	List<Product> getAllProduct();
	/**
	 * 获取产品详细
	 * @return
	 */
	Product getProductById(int id);
	/**
	 * 新增产品
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
