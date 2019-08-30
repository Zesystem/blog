package com.blog.enity;

import java.io.Serializable;

/**
 * @description 该类是实体类，为登陆的用户信息。
 * @author Zesystem
 * @date 2019-8-15
 */
public class User implements Serializable{
	private int id;
	private String username;
	private String password;
	private String phone;
	private String email;
	private String signature;
	private String name;
	private String github;
	private String logoSrc;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}
	/**
	 * @param signature the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the github
	 */
	public String getGithub() {
		return github;
	}
	/**
	 * @param github the github to set
	 */
	public void setGithub(String github) {
		this.github = github;
	}
	/**
	 * @return the logoSrc
	 */
	public String getLogoSrc() {
		return logoSrc;
	}
	/**
	 * @param logoSrc the logoSrc to set
	 */
	public void setLogoSrc(String logoSrc) {
		this.logoSrc = logoSrc;
	}
	public User(int id, String username, String password, String phone, String email, String signature, String name,
			String github, String logoSrc) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.signature = signature;
		this.name = name;
		this.github = github;
		this.logoSrc = logoSrc;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone + ", email="
				+ email + ", signature=" + signature + ", name=" + name + ", github=" + github + ", logoSrc=" + logoSrc
				+ "]";
	}
}
