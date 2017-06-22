package com.zjzt.bean.zzw;
/**
 * 用户小区类
 * @author newmeLee
 *
 */
public class Community {

	private String name;//小区名称
	private String address;//地址
	private String longitude;//小区经度
	private String latitude;//小区纬度
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
}
