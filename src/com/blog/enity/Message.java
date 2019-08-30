package com.blog.enity;

import java.io.Serializable;
import java.sql.Date;

/**
 * @description 该类是实体类，博客新闻条信息。
 * @author Zesystem
 * @date 2019-8-15
 */
public class Message implements Serializable{
	private int id;
	private String title;
	private String content;
	private String desc;
	private int uid;
	private Date time;
	private String author="";
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Message(int id, String title, String content, String desc, int uid,Date time) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.desc = desc;
		this.uid = uid;
		this.time = time;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Message [id=" + id + ", title=" + title + ", content=" + content + ", desc=" + desc + ", uid=" + uid
				+ ", time=" + time + "]";
	}
	
	
}