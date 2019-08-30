package com.blog.enity;

import java.io.Serializable;

/**
 * @description 该类是用于记录所有的栏目信息。
 * @author Zesystem
 * @date 2019-8-15
 */
public class Clazz implements Serializable {
	public int id;
	public String clazz;
	private int uid;
	public Clazz(int id, String clazz,int uid) {
		super();
		this.id = id;
		this.clazz = clazz;
		this.uid = uid;
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
	 * @return the clazz
	 */
	public String getClazz() {
		return clazz;
	}
	/**
	 * @param clazz the clazz to set
	 */
	public void setClazz(String clazz) {
		this.clazz = clazz;
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
		return "Clazz [id=" + id + ", clazz=" + clazz + ", uid=" + uid + "]";
	}
	
	
}