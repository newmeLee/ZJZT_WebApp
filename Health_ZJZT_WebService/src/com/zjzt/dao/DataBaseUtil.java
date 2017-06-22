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
	 * �û���֤��������֤�û�����ȷ��
	 * 
	 * @param userId
	 *            �˺�
	 * @param password
	 *            ����
	 * @return
	 */
	public boolean UserValidate(String userId, String password) {
		boolean flag = false;
		sql = "select * from webservice_users where userId='" + userId
				+ "' And password='" + password + "'";
		db1 = new DBHelper(sql);// ����DBHelper����
		// System.out.println(sql);
		try {
			ret = db1.pst.executeQuery();
			ret.last(); // ��λ�����һ��
			int rowCount = ret.getRow(); // ȡ�����һ�е��кţ�����ѯ������ļ�¼������
			if (rowCount > 0) {

				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}// ִ����䣬�õ������
		return flag;
	}

	/**
	 * ��ȡ��ϸ��������Ϣ
	 * 
	 * @return
	 */
	public ArrayList<HealthNewsBean> getDetaliNews() {
		sql = "select * from health_news";
		return getResultBySql(sql);
	}

	/**
	 * �������ŷ����ȡ������ϸ��Ϣ
	 * 
	 * @param classId
	 *            �����ŷ���ID
	 * @return
	 */
	public ArrayList<HealthNewsBean> getDetaliNews(int classId) {
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("SELECT * FROM health_news ");
		sbSql.append(" WHERE info_class =" + classId + "");
		return getResultBySql(sbSql.toString());
	}

	/**
	 * ��ȡ���ŷ���
	 * 
	 * @return
	 */
	public ArrayList<NewsClassBean> getNewsInfoClass() {
		ArrayList<NewsClassBean> classList = new ArrayList<NewsClassBean>();
		sql = "select * from news_class";// SQL���
		db1 = new DBHelper(sql);// ����DBHelper����
		try {
			ret = db1.pst.executeQuery();// ִ����䣬�õ������
			while (ret.next()) {
				NewsClassBean classBean = new NewsClassBean();
				classBean
						.setClassId(Integer.parseInt(ret.getString("class_id")));
				classBean.setClassName(ret.getString("class_name"));
				// System.out.println("�������ƣ�" + ret.getString("class_name"));
				classList.add(classBean);
			}// ��ʾ����
			ret.close();
			db1.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classList;
	}

	/**
	 * ����sql����ѯ��������
	 * 
	 * @param sql
	 * @return
	 */
	public ArrayList<HealthNewsBean> getResultBySql(String sql) {
		ArrayList<HealthNewsBean> newsList = new ArrayList<HealthNewsBean>();
		db1 = new DBHelper(sql);// ����DBHelper����
		try {
			ret = db1.pst.executeQuery();// ִ����䣬�õ������
			// System.out.println("�������:" + ret.getRow());
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
				// System.out.println("������"+ret.getString(1) + "\t ��������" +
				// ret.getString(2));
			}// ��ʾ����
			ret.close();
			db1.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newsList;
	}

	/**
	 * ��ȡ�û�ѡ��ҳ���б���Ϣ
	 * 
	 * @return
	 */
	public ArrayList<UserOptionBean> getUserOption() {
		optionList = new ArrayList<UserOptionBean>();
		sql = "select * from user_option";// SQL���
		db1 = new DBHelper(sql);// ����DBUtil����
		try {
			ret = db1.pst.executeQuery();// ִ����䣬�õ������
			while (ret.next()) {
				UserOptionBean optionBean = new UserOptionBean();
				optionBean.setOptionId(Integer.parseInt(ret
						.getString("option_id")));
				// System.out.println("ѡ���ţ�" + ret.getString("option_id"));
				optionBean.setOptionName(ret.getString("option_name"));
				optionBean.setOptionIcon(ret.getString("option_icon"));
				optionBean.setOrderNo(Integer.parseInt(ret
						.getString("order_no")));
				optionBean.setOptionUrl(ret.getString("option_url"));
				// System.out.println("�������ƣ�" + ret.getString("class_name"));
				optionList.add(optionBean);
			}// ��ʾ����
			ret.close();
			db1.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return optionList;
	}

	/**
	 * �����û��ֻ������ȡ����֮�ݣ��û�������Ϣ
	 * 
	 * @param phone
	 * @return
	 */
	public ArrayList<UserInfo> getUserBaseInfo(String phone) {
		userInfos = new ArrayList<UserInfo>();
		sql = "select * from busin_user_info where phone='" + phone + "'";
		db1 = new DBHelper(sql);// ����DBHelper����
		try {
			ret = db1.pst.executeQuery();// ִ����䣬�õ������
			while (ret.next()) {
				UserInfo userModel = new UserInfo();
				userModel.setName(ret.getString("name"));
				userModel.setPhone(ret.getString("phone"));
				userInfos.add(userModel);
			}
			ret.close();
			db1.close();// �ر�����
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println(e.getMessage());
		}
		return userInfos;
	}

	/**
	 * �����û��ֻ������ȡ�û�סַ��Ϣ
	 * 
	 * @param phone
	 * @return
	 */
	public ArrayList<CellInfo> getUserAddressInfo(String phone) {
		cellInfos = new ArrayList<CellInfo>();
		sql = "select * from busin_user_address where user_phone='" + phone
				+ "'";
		db1 = new DBHelper(sql);// ����DBHelper����
		try {
			ret = db1.pst.executeQuery();// ִ����䣬�õ������
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
			db1.close();// �ر�����
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cellInfos;
	}

	/**
	 * �ж��û��Ƿ����
	 * 
	 * @param phone
	 *            ���ֻ�����
	 * @return
	 */
	public boolean existUser(String phone) {
		boolean flag = false;
		sql = "select * from busin_user_info where phone='" + phone + "'";
		db1 = new DBHelper(sql);// ����DBHelper����
		// System.out.println(sql);
		try {
			ret = db1.pst.executeQuery();
			ret.last(); // ��λ�����һ��
			int rowCount = ret.getRow(); // ȡ�����һ�е��кţ�����ѯ������ļ�¼������
			if (rowCount > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}// ִ����䣬�õ������
		return flag;
	}

	/**
	 * ��ȡ�û�������������(�����ֻ�����)
	 * 
	 * @param phone
	 * @return
	 */
	public ArrayList<UserHealthInfo> getUserHealthInfo(String phone) {
		// System.out.println(phone);
		ArrayList<UserHealthInfo> userHealthInfos = new ArrayList<UserHealthInfo>();
		sql = "select * from busin_user_health_info where phone='" + phone
				+ "'";
		db1 = new DBHelper(sql);// ����DBHelper����
		try {
			ret = db1.pst.executeQuery();// ִ����䣬�õ������
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
			}// ��ʾ����
			ret.close();
			db1.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userHealthInfos;
	}

	/**
	 * �޸Ľ���������Ϣ
	 * 
	 * @author newmeLee
	 * @param columnName
	 *            �ֶ���
	 * @param value
	 *            �ֶ�ֵ
	 * @return
	 */
	public int updateUserHealthInfo(String columnName, Object value,
			String phone) {
		int result = 0;
		if (value instanceof String) {// ����ֶ����ַ���
			sql = "update busin_user_health_info set " + columnName + " ='"
					+ value + "' where phone='" + phone + "'";
		} else {
			sql = "update busin_user_health_info set " + columnName + " ="
					+ value + " where phone='" + phone + "'";
		}
		db1 = new DBHelper(sql);// ����DBHelper����
		// System.out.println(sql);
		try {
			result = db1.pst.executeUpdate();// ִ����䣬�õ������
			ret.close();
			db1.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * �޸��û��Ļ�����Ϣ(Ŀǰֻ���޸��û���)
	 * 
	 * @param columnName
	 * @param vlaue
	 * @param phone
	 * @return
	 */
	public int updateUserBaseInfo(String columnName, Object value, String phone) {
		int result = 0;
		if (value instanceof String) {// ����ֶ����ַ���
			sql = "update busin_user_info set " + columnName + " ='" + value
					+ "' where phone='" + phone + "'";
		} else {
			sql = "update busin_user_info set " + columnName + " =" + value
					+ " where phone='" + phone + "'";
		}
		db1 = new DBHelper(sql);// ����DBHelper����
		// System.out.println(sql);
		try {
			result = db1.pst.executeUpdate();// ִ����䣬�õ������
			ret.close();
			db1.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ���������͵绰�����û�������Ϣ
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
		db1 = new DBHelper(sql);// ����DBHelper����
		// System.out.println(sql);
		try {
			result = db1.pst.executeUpdate();// ִ����䣬�õ������
			ret.close();
			db1.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ���������͵绰�����û�����������Ϣ
	 * 
	 * @param phone
	 * @param name
	 * @return
	 */
	public int saveUserHealthInfo(String phone, String name) {
		int result = 0;
		sql = "insert into busin_user_health_info(id,phone,name) values(0,'"
				+ phone + "','" + name + "')";
		db1 = new DBHelper(sql);// ����DBHelper����
		// System.out.println(sql);
		try {
			result = db1.pst.executeUpdate();// ִ����䣬�õ������
			ret.close();
			db1.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * �޸��û�����
	 * 
	 * @param phone
	 * @param newPassword
	 * @return
	 */
	public int updateUserPassword(String phone, String newPassword) {
		int result = 0;
		sql = "update busin_user_password set user_password='" + newPassword
				+ "' where phone='" + phone + "'";
		db1 = new DBHelper(sql);// ����DBHelper����
		try {
			result = db1.pst.executeUpdate();// ִ����䣬�õ������
			ret.close();
			db1.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ��ȡ�û�����
	 * 
	 * @param phone
	 * @return
	 */
	public UserPasswordBean getUserPassword(String phone) {
		userPasswordBean = new UserPasswordBean();
		sql = "select * from busin_user_password where phone='"
				+ phone + "'";
		db1 = new DBHelper(sql);// ����DBHelper����
		try {
			ret = db1.pst.executeQuery();// ִ����䣬�õ������
			while (ret.next()) {
				userPasswordBean.setPhone(ret.getString("phone"));
				userPasswordBean.setPassword(ret.getString("user_password"));
				// �����û�����ʵ����
			}
			ret.close();
			db1.close();// �ر�����
		} catch (Exception e) {
			
		}
		return userPasswordBean;
	}
}