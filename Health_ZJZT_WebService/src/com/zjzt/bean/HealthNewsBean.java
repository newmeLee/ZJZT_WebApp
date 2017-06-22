package com.zjzt.bean;
/**
 * 新闻实体类
 * @author Administrator
 *
 */
public class HealthNewsBean {
	public String keyWord;//关键字
	public String title;//标题
	public String summary;//摘要
	public String img;//图片
	public String content;//内容
	public int info_class;
	public String publishDate;//发布时间
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String sunmmary) {
		this.summary = sunmmary;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getInfo_class() {
		return info_class;
	}
	public void setInfo_class(int info_class) {
		this.info_class = info_class;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
}
