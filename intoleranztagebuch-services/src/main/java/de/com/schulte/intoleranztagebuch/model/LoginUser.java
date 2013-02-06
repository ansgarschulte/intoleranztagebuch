package de.com.schulte.intoleranztagebuch.model;

import java.io.Serializable;

public class LoginUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7271876722024601440L;
	private String user;
	private String password;

	public LoginUser(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	public LoginUser() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
