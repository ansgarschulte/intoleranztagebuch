package de.com.schulte.intoleranztagebuch.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6098924876011413852L;
	private String id;
	private String username;
	private String surname;
	private String name;
	private String email;
	private String passwordHash;
	private List<Entry> entries;

	public User() {
		id = UUID.randomUUID().toString();
		entries = new ArrayList<Entry>();
	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

}
