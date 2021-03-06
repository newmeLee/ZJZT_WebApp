package com.zjzt.webService;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "ZJZT_HealthNews", // 服务实现类的名称
serviceName = "ZJZT_HealthNewsService", // 默认在发布的服务实现者的名称后面添加Service
portName = "ZJZT_HealthNewsServicePort", // 服务类型的名称: 默认在 发布的服务实现者(MyWebService)
targetNamespace = "webService.zjzt.com" // 发布ws服务的命名空间,此空间默认为当前服务包路径的 "倒写"此名称也是
)
public interface HealthInfoService {

	/**
	 * 获取所有的健康咨讯信息
	 * 
	 * @param userId
	 *            用户名
	 * @param password
	 *            密码
	 * @return Json字符串形式的资讯信息
	 */
	@WebResult(name = "HealthNews")
	String getAllHealthNews(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password);

	/**
	 * 根据新闻分类Id获取相关新闻资讯
	 * 
	 * @param userId
	 *            用户名
	 * @param password
	 *            密码
	 * @param classId
	 *            新闻分类Id
	 * @return Json字符串形式的新闻信息
	 */
	@WebResult(name = "HealthNews")
	String getHealthNewsById(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password,
			@WebParam(name = "classId") int classId);

	/**
	 * 
	 * @param userId
	 *            用户名
	 * @param password
	 *            用户账号
	 * @return
	 */
	@WebResult(name = "HealthNewsClass")
	String getHealthNewsClass(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password);

	/**
	 * 获取用户选项页面的列表信息
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	@WebResult(name = "UserOption")
	String getUserOptions(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password);

	/**
	 * 根据手机号码查询用户基本信息
	 * 
	 * @param userId
	 * @param password
	 * @param phone
	 * @return
	 */
	@WebResult(name = "UserInfo")
	String getUserBaseInfo(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password,
			@WebParam(name = "phone") String phone);

	/**
	 * 判断用户是否存在
	 * 
	 * @param phone
	 * @return
	 */
	@WebResult(name = "existFlag")
	String existUser(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password,
			@WebParam(name = "phone") String phone);

	/**
	 * 根据手机号获取用户健康档案信息
	 * 
	 * @param userId
	 * @param password
	 * @param phone
	 * @return
	 */
	@WebResult(name = "UserHealthInfo")
	String getUserHealthInfo(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password,
			@WebParam(name = "phone") String phone);

	/**
	 * 修改用户健康档案信息
	 * 
	 * @param userId
	 * @param password
	 * @param columnName
	 * @param value
	 * @param phone
	 * @return
	 */
	@WebResult(name = "updateFlag")
	String updateUserHealthInfo(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password,
			@WebParam(name = "columnName") String columnName,
			@WebParam(name = "value") Object value,
			@WebParam(name = "phone") String phone);

	/**
	 * 修改用户基本信息
	 * 
	 * @param userId
	 * @param password
	 * @param columnName
	 * @param value
	 * @param phone
	 * @return
	 */
	@WebResult(name = "updateFlag")
	String updateUserBaseInfo(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password,
			@WebParam(name = "columnName") String columnName,
			@WebParam(name = "value") Object value,
			@WebParam(name = "phone") String phone);

	/**
	 * 根据用户姓名和号码新增基本信息
	 * 
	 * @param userId
	 * @param password
	 * @param phone
	 * @param name
	 * @return
	 */
	@WebResult(name = "saveFlag")
	String saveUserBaseInfo(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password,
			@WebParam(name = "phone") String phone,
			@WebParam(name = "name") String name);

	/**
	 * 根据用户姓名和号码新增用户档案信息
	 * 
	 * @param userId
	 * @param password
	 * @param phone
	 * @param name
	 * @return
	 */
	@WebResult(name = "saveFlag")
	String saveUserHealthInfo(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password,
			@WebParam(name = "phone") String phone,
			@WebParam(name = "name") String name);

	/**
	 * 修改用户密码
	 * 
	 * @param phone
	 * @param newPassword
	 * @return
	 */
	@WebResult(name = "updateUserPassword")
	String updateUserPassword(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password,
			@WebParam(name = "phone") String phone,
			@WebParam(name = "newPassword") String newPassword);
	/**
	 * 获取用户的密码
	 * @param userId
	 * @param password
	 * @param phone
	 * @return
	 */
	@WebResult(name="getUserPassword")
	String getUserPassword(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password,
			@WebParam(name = "phone") String phone);
}
