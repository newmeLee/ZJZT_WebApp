package com.zjzt.webService;

import com.google.gson.Gson;
import com.zjzt.bean.NewsClassForJsonBean;
import com.zjzt.bean.NewsForJsonBean;
import com.zjzt.bean.UserHealthInfoForJson;
import com.zjzt.bean.UserOptionForJsonBean;
import com.zjzt.bean.WebServiceResultForJson;
import com.zjzt.bean.zzw.UserInfoForJson;
import com.zjzt.dao.DataBaseUtil;

public class HealthInfoServiceImpl implements HealthInfoService {
	Gson gson = new Gson();
	DataBaseUtil dbUtil = new DataBaseUtil();
	// 用户选项信息Json类
	UserOptionForJsonBean optionJson = null;
	// 用户基本信息Json类
	UserInfoForJson userInfoForJson = null;
	// 单个结果Json类
	WebServiceResultForJson serviceResultForJson = null;
	// 用户健康信息Json类
	UserHealthInfoForJson userHealthInfoForJson = null;

	// 常量设置
	private static final String VALIDATE_TRUE_MSG = "WebService用户验证成功";
	private static final String VALIDATE_FALSE_MSG = "WebService用户验证失败";
	private static final String EXECUTE_FLAG_TRUE = "1";
	private static final String EXECUTE_FLAG_FALSE = "0";

	/**
	 * 获取所有新闻
	 */
	public String getAllHealthNews(String userId, String password) {
		NewsForJsonBean news = new NewsForJsonBean();
		if (dbUtil.UserValidate(userId, password)) {
			news.setStatus(true);
			news.setMessage(VALIDATE_TRUE_MSG);
			news.setNewsList(dbUtil.getDetaliNews());
			// System.out.println("传输结果："+news);
		} else {
			news.setStatus(false);
			news.setMessage(VALIDATE_FALSE_MSG);
		}
		return gson.toJson(news);
	}

	/**
	 * 获取健康新闻
	 */
	public String getHealthNewsById(String userId, String password, int classId) {
		NewsForJsonBean news = new NewsForJsonBean();
		if (dbUtil.UserValidate(userId, password)) {
			news.setStatus(true);
			news.setMessage(VALIDATE_TRUE_MSG);
			news.setNewsList(dbUtil.getDetaliNews(classId));
		} else {
			news.setStatus(false);
			news.setMessage(VALIDATE_FALSE_MSG);
		}
		return gson.toJson(news);
	}

	/**
	 * 获取健康新闻分类列表
	 */
	public String getHealthNewsClass(String userId, String password) {
		NewsClassForJsonBean newsClass = new NewsClassForJsonBean();
		if (dbUtil.UserValidate(userId, password)) {
			newsClass.setStatus(true);
			newsClass.setMessage(VALIDATE_TRUE_MSG);
			newsClass.setClassList(dbUtil.getNewsInfoClass());
		} else {
			newsClass.setStatus(false);
			newsClass.setMessage(VALIDATE_FALSE_MSG);
		}
		return gson.toJson(newsClass);
	}

	/**
	 * 获取用户选项页面的列表信息
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	public String getUserOptions(String userId, String password) {
		optionJson = new UserOptionForJsonBean();
		if (dbUtil.UserValidate(userId, password)) {
			optionJson.setStatus(true);
			optionJson.setMessage(VALIDATE_TRUE_MSG);
			optionJson.setOptionList(dbUtil.getUserOption());
			// System.out.println("获取到的用户选项结果为:"+optionJson.optionList);
		} else {
			optionJson.setStatus(false);
			optionJson.setMessage(VALIDATE_FALSE_MSG);
		}
		return gson.toJson(optionJson);
	}

	/**
	 * 根据手机号码获取用户基本信息（姓名和住址等） 2017-2-21
	 */
	public String getUserBaseInfo(String userId, String password, String phone) {
		// TODO Auto-generated method stub
		userInfoForJson = new UserInfoForJson();
		if (dbUtil.UserValidate(userId, password)) {
			userInfoForJson.setStatus(true);
			userInfoForJson.setMessage(VALIDATE_TRUE_MSG);
			if (dbUtil.getUserBaseInfo(phone).size() > 0) {
				userInfoForJson.setUserInfo(dbUtil.getUserBaseInfo(phone)
						.get(0));
			}

			if (dbUtil.getUserAddressInfo(phone).size() > 0) {
				userInfoForJson.setCellInfo(dbUtil.getUserAddressInfo(phone)
						.get(0));
			}
		} else {
			userInfoForJson.setStatus(false);
			userInfoForJson.setMessage(VALIDATE_FALSE_MSG);
		}
		return gson.toJson(userInfoForJson);
	}

	/**
	 * 根据与手机号判断用户是否存在2017-2-28
	 */
	public String existUser(String userId, String password, String phone) {
		// TODO Auto-generated method stub
		serviceResultForJson = new WebServiceResultForJson();
		if (dbUtil.UserValidate(userId, password)) {
			serviceResultForJson.setStatus(true);
			serviceResultForJson.setMessage(VALIDATE_TRUE_MSG);
			if (dbUtil.existUser(phone)) {
				serviceResultForJson.setValue(EXECUTE_FLAG_TRUE);
			} else {
				serviceResultForJson.setValue(EXECUTE_FLAG_FALSE);
			}
		} else {
			serviceResultForJson.setStatus(false);
			serviceResultForJson.setMessage(VALIDATE_FALSE_MSG);
		}
		return gson.toJson(serviceResultForJson);
	}

	/**
	 * 根据手机号查找用户健康档案信息2017-2-28
	 */
	public String getUserHealthInfo(String userId, String password, String phone) {
		userHealthInfoForJson = new UserHealthInfoForJson();
		if (dbUtil.UserValidate(userId, password)) {
			userHealthInfoForJson.setStatus(true);
			userHealthInfoForJson.setMessage(VALIDATE_TRUE_MSG);
			if (dbUtil.getUserHealthInfo(phone).size() > 0) {
				userHealthInfoForJson.setUserHealthInfo(dbUtil
						.getUserHealthInfo(phone).get(0));
			}
		} else {
			userHealthInfoForJson.setStatus(false);
			userHealthInfoForJson.setMessage(VALIDATE_FALSE_MSG);
		}
		return gson.toJson(userHealthInfoForJson);
	}

	/**
	 * 更新用户档案信息2017-2-28
	 */
	public String updateUserHealthInfo(String userId, String password,
			String columnName, Object value, String phone) {
		// TODO Auto-generated method stub
		serviceResultForJson = new WebServiceResultForJson();
		if (dbUtil.UserValidate(userId, password)) {
			serviceResultForJson.setStatus(true);
			serviceResultForJson.setMessage(VALIDATE_TRUE_MSG);
			if (dbUtil.updateUserHealthInfo(columnName, value, phone) > 0) {
				serviceResultForJson.setValue(EXECUTE_FLAG_TRUE);
			} else {
				serviceResultForJson.setValue(EXECUTE_FLAG_FALSE);
			}
		} else {
			serviceResultForJson.setStatus(false);
			serviceResultForJson.setMessage(VALIDATE_FALSE_MSG);
		}
		return gson.toJson(serviceResultForJson);
	}

	/**
	 * 更新用户基本信息
	 */
	public String updateUserBaseInfo(String userId, String password,
			String columnName, Object value, String phone) {
		// TODO Auto-generated method stub
		serviceResultForJson = new WebServiceResultForJson();
		if (dbUtil.UserValidate(userId, password)) {
			serviceResultForJson.setStatus(true);
			serviceResultForJson.setMessage(VALIDATE_TRUE_MSG);
			if (dbUtil.updateUserBaseInfo(columnName, value, phone) > 0) {
				serviceResultForJson.setValue(EXECUTE_FLAG_TRUE);
			} else {
				serviceResultForJson.setValue(EXECUTE_FLAG_FALSE);
			}
		} else {
			serviceResultForJson.setStatus(false);
			serviceResultForJson.setMessage(VALIDATE_FALSE_MSG);
		}
		return gson.toJson(serviceResultForJson);
	}

	/**
	 * 新增用户基本信息
	 */
	public String saveUserBaseInfo(String userId, String password,
			String phone, String name) {
		// TODO Auto-generated method stub
		serviceResultForJson = new WebServiceResultForJson();
		if (dbUtil.UserValidate(userId, password)) {
			serviceResultForJson.setStatus(true);
			serviceResultForJson.setMessage(VALIDATE_TRUE_MSG);
			if (dbUtil.saveUserBaseInfo(phone, name) > 0) {
				serviceResultForJson.setValue(EXECUTE_FLAG_TRUE);
			} else {
				serviceResultForJson.setValue(EXECUTE_FLAG_FALSE);
			}
		} else {
			serviceResultForJson.setStatus(false);
			serviceResultForJson.setMessage(VALIDATE_FALSE_MSG);
		}
		return gson.toJson(serviceResultForJson);
	}

	/**
	 * 新增用户健档案信息
	 */
	public String saveUserHealthInfo(String userId, String password,
			String phone, String name) {
		// TODO Auto-generated method stub
		serviceResultForJson = new WebServiceResultForJson();
		if (dbUtil.UserValidate(userId, password)) {
			serviceResultForJson.setStatus(true);
			serviceResultForJson.setMessage(VALIDATE_TRUE_MSG);
			if (dbUtil.saveUserHealthInfo(phone, name) > 0) {
				serviceResultForJson.setValue(EXECUTE_FLAG_TRUE);
			} else {
				serviceResultForJson.setValue(EXECUTE_FLAG_FALSE);
			}
		} else {
			serviceResultForJson.setStatus(false);
			serviceResultForJson.setMessage(VALIDATE_FALSE_MSG);
		}
		return gson.toJson(serviceResultForJson);
	}

	/**
	 * 修改用户密码
	 */
	public String updateUserPassword(String userId, String password,
			String phone, String newPassword) {
		// TODO Auto-generated method stub
		serviceResultForJson = new WebServiceResultForJson();
		if (dbUtil.UserValidate(userId, password)) {
			serviceResultForJson.setStatus(true);
			serviceResultForJson.setMessage(VALIDATE_TRUE_MSG);
			if (dbUtil.updateUserPassword(phone, newPassword) > 0) {
				serviceResultForJson.setValue(EXECUTE_FLAG_TRUE);
			} else {
				serviceResultForJson.setValue(EXECUTE_FLAG_FALSE);
			}
		} else {
			serviceResultForJson.setStatus(false);
			serviceResultForJson.setMessage(VALIDATE_FALSE_MSG);
		}
		return gson.toJson(serviceResultForJson);
	}

	/**
	 * 获取用户密码
	 */
	public String getUserPassword(String userId, String password, String phone) {
		// TODO Auto-generated method stub
		serviceResultForJson = new WebServiceResultForJson();
		if (dbUtil.UserValidate(userId, password)) {
			serviceResultForJson.setStatus(true);
			serviceResultForJson.setMessage(VALIDATE_TRUE_MSG);
			if (null != dbUtil.getUserPassword(phone)) {
				serviceResultForJson.setValue(dbUtil.getUserPassword(phone)
						.getPassword());
			}
		} else {
			serviceResultForJson.setStatus(false);
			serviceResultForJson.setMessage(VALIDATE_FALSE_MSG);
		}
		return gson.toJson(serviceResultForJson);
	}
}
