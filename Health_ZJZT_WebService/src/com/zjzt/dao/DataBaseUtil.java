package com.zjzt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zjzt.bean.HealthNewsBean;
import com.zjzt.bean.NewsClassBean;
import com.zjzt.bean.UserHealthInfo;
import com.zjzt.bean.UserOptionBean;
import com.zjzt.bean.UserPasswordBean;
import com.zjzt.bean.zzw.Build;
import com.zjzt.bean.zzw.Cell;
import com.zjzt.bean.zzw.CellInfo;
import com.zjzt.bean.zzw.Community;

import com.zjzt.bean.zzw.UserInfo;

public class DataBaseUtil {
	static String sql = null;
	static DBHelper db1 = null;
	static ResultSet ret = null;
	ArrayList<UserInfo> userInfos = null;
	ArrayList<CellInfo> cellInfos = null;
	//
	ArrayList<UserOptionBean> optionList = null;
	//
	UserPasswordBean userPasswordBean = null;

	/**
	 * 用户验证，用来验证用户的正确性
	 * 
	 * @param userId
	 *            账号
	 * @param password
	 *            密码
	 * @return
	 */
	public boolean UserValidate(String userId, String password) {
		boolean flag = false;
		sql = "select * from webservice_users where userId='" + userId
				+ "' And password='" + password + "'";
		db1 = new DBHelper(sql);// 创建DBHelper对象
		// System.out.println(sql);
		try {
			ret = db1.pst.executeQuery();
			ret.last(); // 定位到最后一行
			int rowCount = ret.getRow(); // 取得最后一行的行号，即查询结果集的记录总行数
			if (rowCount > 0) {

				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}// 执行语句，得到结果集
		return flag;
	}

	/**
	 * 获取详细的新闻信息
	 * 
	 * @return
	 */
	public ArrayList<HealthNewsBean> getDetaliNews() {
		sql = "select * from health_news";
		return getResultBySql(sql);
	}

	/**
	 * 根据新闻分类获取新闻详细信息
	 * 
	 * @param classId
	 *            ：新闻分类ID
	 * @return
	 */
	public ArrayList<HealthNewsBean> getDetaliNews(int classId) {
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("SELECT * FROM health_news ");
		sbSql.append(" WHERE info_class =" + classId + "");
		return getResultBySql(sbSql.toString());
	}

	/**
	 * 获取新闻分类
	 * 
	 * @return
	 */
	public ArrayList<NewsClassBean> getNewsInfoClass() {
		ArrayList<NewsClassBean> classList = new ArrayList<NewsClassBean>();
		sql = "select * from news_class";// SQL语句
		db1 = new DBHelper(sql);// 创建DBHelper对象
		try {
			ret = db1.pst.executeQuery();// 执行语句，得到结果集
			while (ret.next()) {
				NewsClassBean classBean = new NewsClassBean();
				classBean
						.setClassId(Integer.parseInt(ret.getString("class_id")));
				classBean.setClassName(ret.getString("class_name"));
				// System.out.println("分类名称：" + ret.getString("class_name"));
				classList.add(classBean);
			}// 显示数据
			ret.close();
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classList;
	}

	/**
	 * 根据sql语句查询新闻数据
	 * 
	 * @param sql
	 * @return
	 */
	public ArrayList<HealthNewsBean> getResultBySql(String sql) {
		ArrayList<HealthNewsBean> newsList = new ArrayList<HealthNewsBean>();
		db1 = new DBHelper(sql);// 创建DBHelper对象
		try {
			ret = db1.pst.executeQuery();// 执行语句，得到结果集
			// System.out.println("结果行数:" + ret.getRow());
			while (ret.next()) {
				HealthNewsBean newsBean = new HealthNewsBean();
				newsBean.setKeyWord(ret.getString("keyword"));

				newsBean.setTitle(ret.getString("title"));
				newsBean.setSummary(ret.getString("summary"));
				newsBean.setContent(ret.getString("content"));
				newsBean.setImg(ret.getString("img"));
				newsBean.setInfo_class(Integer.parseInt(ret
						.getString("info_class")));
				newsBean.setPublishDate((ret.getString("publish_date")));
				newsList.add(newsBean);
				// System.out.println("分类编号"+ret.getString(1) + "\t 分类名称" +
				// ret.getString(2));
			}// 显示数据
			ret.close();
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newsList;
	}

	/**
	 * 获取用户选项页的列表信息
	 * 
	 * @return
	 */
	public ArrayList<UserOptionBean> getUserOption() {
		optionList = new ArrayList<UserOptionBean>();
		sql = "select * from user_option";// SQL语句
		db1 = new DBHelper(sql);// 创建DBUtil对象
		try {
			ret = db1.pst.executeQuery();// 执行语句，得到结果集
			while (ret.next()) {
				UserOptionBean optionBean = new UserOptionBean();
				optionBean.setOptionId(Integer.parseInt(ret
						.getString("option_id")));
				// System.out.println("选项编号：" + ret.getString("option_id"));
				optionBean.setOptionName(ret.getString("option_name"));
				optionBean.setOptionIcon(ret.getString("option_icon"));
				optionBean.setOrderNo(Integer.parseInt(ret
						.getString("order_no")));
				optionBean.setOptionUrl(ret.getString("option_url"));
				// System.out.println("分类名称：" + ret.getString("class_name"));
				optionList.add(optionBean);
			}// 显示数据
			ret.close();
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return optionList;
	}

	/**
	 * 根据用户手机号码获取（智之屋）用户基本信息
	 * 
	 * @param phone
	 * @return
	 */
	public ArrayList<UserInfo> getUserBaseInfo(String phone) {
		userInfos = new ArrayList<UserInfo>();
		sql = "select * from busin_user_info where phone='" + phone + "'";
		db1 = new DBHelper(sql);// 创建DBHelper对象
		try {
			ret = db1.pst.executeQuery();// 执行语句，得到结果集
			while (ret.next()) {
				UserInfo userModel = new UserInfo();
				userModel.setName(ret.getString("name"));
				userModel.setPhone(ret.getString("phone"));
				userInfos.add(userModel);
			}
			ret.close();
			db1.close();// 关闭连接
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println(e.getMessage());
		}
		return userInfos;
	}

	/**
	 * 根据用户手机号码获取用户住址信息
	 * 
	 * @param phone
	 * @return
	 */
	public ArrayList<CellInfo> getUserAddressInfo(String phone) {
		cellInfos = new ArrayList<CellInfo>();
		sql = "select * from busin_user_address where user_phone='" + phone
				+ "'";
		db1 = new DBHelper(sql);// 创建DBHelper对象
		try {
			ret = db1.pst.executeQuery();// 执行语句，得到结果集
			while (ret.next()) {
				Community community = new Community();
				community.setName(ret.getString("community_name"));
				community.setAddress(ret.getString("community_address"));
				community.setLatitude(ret.getString("community_latiude"));
				community.setLongitude(ret.getString("community_longtiude"));
				//
				Build build = new Build();
				build.setNum(ret.getString("build_num"));
				//
				Cell cell = new Cell();
				cell.setNum(ret.getString("cell_num"));
				//
				CellInfo cellInfo = new CellInfo();
				cellInfo.setArea(ret.getString("area"));
				cellInfo.setBuild(build);
				cellInfo.setCell(cell);
				cellInfo.setCommunity(community);
				cellInfos.add(cellInfo);
			}
			ret.close();
			db1.close();// 关闭连接
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cellInfos;
	}

	/**
	 * 判断用户是否存在
	 * 
	 * @param phone
	 *            ：手机号码
	 * @return
	 */
	public boolean existUser(String phone) {
		boolean flag = false;
		sql = "select * from busin_user_info where phone='" + phone + "'";
		db1 = new DBHelper(sql);// 创建DBHelper对象
		// System.out.println(sql);
		try {
			ret = db1.pst.executeQuery();
			ret.last(); // 定位到最后一行
			int rowCount = ret.getRow(); // 取得最后一行的行号，即查询结果集的记录总行数
			if (rowCount > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}// 执行语句，得到结果集
		return flag;
	}

	/**
	 * 获取用户健康档案数据(根据手机号码)
	 * 
	 * @param phone
	 * @return
	 */
	public ArrayList<UserHealthInfo> getUserHealthInfo(String phone) {
		// System.out.println(phone);
		ArrayList<UserHealthInfo> userHealthInfos = new ArrayList<UserHealthInfo>();
		sql = "select * from busin_user_health_info where phone='" + phone
				+ "'";
		db1 = new DBHelper(sql);// 创建DBHelper对象
		try {
			ret = db1.pst.executeQuery();// 执行语句，得到结果集
			while (ret.next()) {
				UserHealthInfo healthInfo = new UserHealthInfo();
				healthInfo.setName(ret.getString("name"));
				healthInfo.setPhone(ret.getString("phone"));
				healthInfo.setGender(ret.getString("gender"));
				if (ret.getString("age") != null) {
					healthInfo.setAge(Integer.parseInt(ret.getString("age")));
				}
				if (ret.getString("height") != null) {
					healthInfo
							.setHeight(Double.valueOf(ret.getString("height")));
				}
				if (ret.getString("weight") != null) {
					healthInfo
							.setWeight(Double.valueOf(ret.getString("weight")));
				}
				if (ret.getString("dBloodPress") != null) {
					healthInfo.setDiaBloodPress(Double.valueOf(ret
							.getString("dBloodPress")));
				}
				if (ret.getString("sBloodPress") != null) {
					healthInfo.setSysBloodPress(Double.valueOf(ret
							.getString("sBloodPress")));
				}
				if (ret.getString("cardiacRate") != null) {
					healthInfo.setCardiacRate(Integer.parseInt(ret
							.getString("cardiacRate")));
				}
				healthInfo.setSickHistory(ret.getString("sickHistory"));
				healthInfo.setAllergyHistory(ret.getString("allergyHistory"));
				healthInfo.setOperationHistory(ret
						.getString("operationHistory"));
				healthInfo.setUserHabit(ret.getString("habit"));
				userHealthInfos.add(healthInfo);
			}// 显示数据
			ret.close();
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userHealthInfos;
	}

	/**
	 * 修改健康档案信息
	 * 
	 * @author newmeLee
	 * @param columnName
	 *            字段名
	 * @param value
	 *            字段值
	 * @return
	 */
	public int updateUserHealthInfo(String columnName, Object value,
			String phone) {
		int result = 0;
		if (value instanceof String) {// 如果字段是字符型
			sql = "update busin_user_health_info set " + columnName + " ='"
					+ value + "' where phone='" + phone + "'";
		} else {
			sql = "update busin_user_health_info set " + columnName + " ="
					+ value + " where phone='" + phone + "'";
		}
		db1 = new DBHelper(sql);// 创建DBHelper对象
		// System.out.println(sql);
		try {
			result = db1.pst.executeUpdate();// 执行语句，得到结果集
			ret.close();
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 修改用户的基本信息(目前只能修改用户名)
	 * 
	 * @param columnName
	 * @param vlaue
	 * @param phone
	 * @return
	 */
	public int updateUserBaseInfo(String columnName, Object value, String phone) {
		int result = 0;
		if (value instanceof String) {// 如果字段是字符型
			sql = "update busin_user_info set " + columnName + " ='" + value
					+ "' where phone='" + phone + "'";
		} else {
			sql = "update busin_user_info set " + columnName + " =" + value
					+ " where phone='" + phone + "'";
		}
		db1 = new DBHelper(sql);// 创建DBHelper对象
		// System.out.println(sql);
		try {
			result = db1.pst.executeUpdate();// 执行语句，得到结果集
			ret.close();
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 根据姓名和电话新增用户基本信息
	 * 
	 * @author newmeLee
	 * @param name
	 * @param phone
	 * @return
	 */
	public int saveUserBaseInfo(String phone, String name) {
		int result = 0;
		sql = "insert into busin_user_info(id,phone,name) values(0,'" + phone
				+ "','" + name + "')";
		db1 = new DBHelper(sql);// 创建DBHelper对象
		// System.out.println(sql);
		try {
			result = db1.pst.executeUpdate();// 执行语句，得到结果集
			ret.close();
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 根据姓名和电话新增用户健康档案信息
	 * 
	 * @param phone
	 * @param name
	 * @return
	 */
	public int saveUserHealthInfo(String phone, String name) {
		int result = 0;
		sql = "insert into busin_user_health_info(id,phone,name) values(0,'"
				+ phone + "','" + name + "')";
		db1 = new DBHelper(sql);// 创建DBHelper对象
		// System.out.println(sql);
		try {
			result = db1.pst.executeUpdate();// 执行语句，得到结果集
			ret.close();
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 修改用户密码
	 * 
	 * @param phone
	 * @param newPassword
	 * @return
	 */
	public int updateUserPassword(String phone, String newPassword) {
		int result = 0;
		sql = "update busin_user_password set user_password='" + newPassword
				+ "' where phone='" + phone + "'";
		db1 = new DBHelper(sql);// 创建DBHelper对象
		try {
			result = db1.pst.executeUpdate();// 执行语句，得到结果集
			ret.close();
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 获取用户密码
	 * 
	 * @param phone
	 * @return
	 */
	public UserPasswordBean getUserPassword(String phone) {
		userPasswordBean = new UserPasswordBean();
		sql = "select * from busin_user_password where phone='"
				+ phone + "'";
		db1 = new DBHelper(sql);// 创建DBHelper对象
		try {
			ret = db1.pst.executeQuery();// 执行语句，得到结果集
			while (ret.next()) {
				userPasswordBean.setPhone(ret.getString("phone"));
				userPasswordBean.setPassword(ret.getString("user_password"));
				// 增加用户密码实体类
			}
			ret.close();
			db1.close();// 关闭连接
		} catch (Exception e) {
			
		}
		return userPasswordBean;
	}
}
