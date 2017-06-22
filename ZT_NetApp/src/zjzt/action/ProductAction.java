package zjzt.action;

import java.util.List;
import java.util.Map;

import zjzt.entity.Product;
import zjzt.service.IProductService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ProductAction extends ActionSupport {

	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String title;
	private String keyword;
	private String content;
	private String describe1;
	private String describe2;
	private String describe3;
	private String describe4;
	private String describe5;
	private String picUrl;
	private String picUrl1;
	private String picUrl2;
	private String picUrl3;
	private int type;
	private String result;
	private Product product;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDescribe1() {
		return describe1;
	}
	public void setDescribe1(String describe1) {
		this.describe1 = describe1;
	}
	public String getDescribe2() {
		return describe2;
	}
	public void setDescribe2(String describe2) {
		this.describe2 = describe2;
	}
	public String getDescribe3() {
		return describe3;
	}
	public void setDescribe3(String describe3) {
		this.describe3 = describe3;
	}
	public String getDescribe4() {
		return describe4;
	}
	public void setDescribe4(String describe4) {
		this.describe4 = describe4;
	}
	public String getDescribe5() {
		return describe5;
	}
	public void setDescribe5(String describe5) {
		this.describe5 = describe5;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getPicUrl1() {
		return picUrl1;
	}
	public void setPicUrl1(String picUrl1) {
		this.picUrl1 = picUrl1;
	}
	public String getPicUrl2() {
		return picUrl2;
	}
	public void setPicUrl2(String picUrl2) {
		this.picUrl2 = picUrl2;
	}
	public String getPicUrl3() {
		return picUrl3;
	}
	public void setPicUrl3(String picUrl3) {
		this.picUrl3 = picUrl3;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	private IProductService productService;
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	/**
	 * 获取所有的产品
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String product_List() {
		List<Product> productList=productService.getAllProducts();
		Map<String,Object> request=(Map<String, Object>) ActionContext.getContext().get("request");
		request.put("productList", productList);
		return SUCCESS;
	}
	/**
	 * 获取产品服务的详细
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getProductById(){
		Map<String,Object> request=(Map<String, Object>) ActionContext.getContext().get("request");
		request.put("product", productService.getProductById(id)) ;
		return SUCCESS;
	}
	/**
	 * 新增或更新产品信息
	 * @return
	 */
	public String addOrUpdateProduct(){
		Product product=new Product();
		product.setTitle(title);
		product.setKeyword(keyword);
		product.setContent(content);
		product.setDescribe1(describe1);
		product.setDescribe2(describe2);
		product.setDescribe3(describe3);
		product.setDescribe4(describe4);
		product.setDescribe5(describe5);
		product.setPicUrl(picUrl);
		product.setPicUrl1(picUrl1);
		product.setPicUrl2(picUrl2);
		product.setPicUrl3(picUrl3);
		product.setType(type);
		product.setOrderNo(9);
		//如果是新增
		if(getId()<1){
			productService.addProduct(product);
		}else{
			product.setId(id);
			productService.updateProduct(product);
		}
		this.setResult("200");
		return SUCCESS;
	}

	/**
	 * 获取产品服务的详细(后台Json数据)
	 * @return
	 */
	@SuppressWarnings("all")
	public String getJsonProductById(){
		this.setProduct(productService.getProductById(id)) ;
		return SUCCESS;
	}
	/**
	 * 删除产品信息
	 * @return
	 */
	public String deleteProduct(){
		if(getId()>0){
			Product product= productService.getProductById(id);
			productService.deleteProduct(product);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
}
