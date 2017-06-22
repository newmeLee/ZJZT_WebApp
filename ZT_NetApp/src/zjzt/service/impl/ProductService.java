package zjzt.service.impl;

import java.util.List;

import zjzt.dao.IProductDao;
import zjzt.entity.Product;
import zjzt.service.IProductService;

public class ProductService implements IProductService {

	private IProductDao productDao;
	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAllProduct();
	}
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productDao.getProductById(id);
	}
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.addProduct(product);
	}
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(product);
	}
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(product);
	}

}
