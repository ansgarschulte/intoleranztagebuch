package de.com.schulte.intoleranztagebuch.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6098924876011413852L;
	private String id;
	private String surname;
	private String name;
	private String email;
	private String password;
	private List<Entry> entries = new ArrayList<Entry>();

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
