package com.zjzt.bean;

import java.util.ArrayList;
/**
 * ����תΪJSON���ʵ��
 * @author Administrator
 *
 */
public class NewsForJsonBean {
	//���ŷ���
	public boolean status;
	public String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public ArrayList<HealthNewsBean> newsList;
	public ArrayList<HealthNewsBean> getNewsList() {
		return newsList;
	}
	public void setNewsList(ArrayList<HealthNewsBean> newsList) {
		this.newsList = newsList;
	}
	
}
