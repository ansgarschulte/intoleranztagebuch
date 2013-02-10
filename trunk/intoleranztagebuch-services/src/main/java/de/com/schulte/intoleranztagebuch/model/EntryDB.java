package de.com.schulte.intoleranztagebuch.model;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class EntryDB implements Serializable {

	private User user;
	// @Autowired(required = false)
	// MongoDbFactory mongoDbFactory;
	@Autowired(required = true)
	private MongoTemplate mongoTemplate;

	private static final long serialVersionUID = 6109802182896950053L;
	private static final Log LOG = LogFactory.getLog(EntryDB.class);

	public User login(String username, String password) {
		if (StringUtils.isNotEmpty(username)
				&& StringUtils.isNotEmpty(password)) {
			try {
				String passwordHash = hash(password);
				User dbUser = mongoTemplate.findOne(
						new Query(Criteria.where("username").is(username)),
						User.class);
				if (dbUser != null
						&& dbUser.getPasswordHash().equals(passwordHash)) {
					user = dbUser;
					LOG.info("User " + username + " logged in");
					return user;
				} else {
					LOG.info("User " + username + " typed wrong password");
				}

			} catch (NoSuchAlgorithmException e) {
				LOG.error("Es ist ein Fehler aufgetreten", e);
				return null;
			}
		}
		return null;
	}

	public boolean register(String username, String password, String surename,
			String name, String email) {
		try {
			User dbUser = mongoTemplate.findOne(
					new Query(Criteria.where("username").is(username)),
					User.class);
			if (dbUser == null) {
				User newUser = new User();
				newUser.setEmail(email);
				newUser.setName(name);
				newUser.setPasswordHash(hash(password));
				newUser.setSurname(surename);
				newUser.setUsername(username);
				mongoTemplate.save(newUser);
				LOG.info("Registered User " + username);
				return true;
			} else {
				LOG.info("User existiert schon");
				return false;
			}
		} catch (NoSuchAlgorithmException e) {
			LOG.error("Es ist ein Fehler aufgetreten", e);
			return false;
		}
	}

	private String hash(String password) throws NoSuchAlgorithmException {
		MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
		byte[] passBytes = password.getBytes();
		byte[] passHash = sha256.digest(passBytes);
		String hash = new String(passHash);
		return hash;
	}

	public List<String> getAllDiscomforts() {
		List<String> discomforts = new ArrayList<String>();
		discomforts.add("");
		discomforts.add("Appetitlosigkeit");
		discomforts.add("Aufstoßen");
		discomforts.add("Bauchschmerzen");
		discomforts.add("Blähbauch");
		discomforts.add("Darm grummeln");
		discomforts.add("Durchfall");
		discomforts.add("Krämpfe");
		discomforts.add("Plötzlich einsetzender Stuhldrang");
		discomforts.add("Übelkeit");
		return discomforts;
	}

	public List<String> getAllAssistanceUsed() {
		List<String> assistances = new ArrayList<String>();
		assistances.add("");
		assistances.add("Fructosin");
		assistances.add("Lactase");
		assistances.add("Traubenzucker");
		return assistances;
	}

	public void persist(Entry entry) {
		List<Entry> entries = user.getEntries();
		removeFromEntryList(entry.getId(), entries);
		entries.add(entry);
		mongoTemplate.save(user);
		LOG.info("Saved User:" + user);
	}

	public List<Entry> getAllEntries() {
		User dbUsers = mongoTemplate.findOne(
				new Query(Criteria.where("id").is(user.getId())), User.class);
		if (dbUsers != null) {
			return dbUsers.getEntries();
		}
		return new ArrayList<Entry>();
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void deleteEntry(Entry entry) {
		String entryId = entry.getId();
		deleteEntry(entryId);
	}

	private void deleteEntry(String entryId) {
		List<Entry> entries = user.getEntries();
		removeFromEntryList(entryId, entries);
		mongoTemplate.save(user);
		LOG.info("Saved User:" + user);
	}

	private void removeFromEntryList(String entryId, List<Entry> entries) {
		for (Iterator<Entry> iterator = entries.iterator(); iterator.hasNext();) {
			Entry e = (Entry) iterator.next();
			if (e.getId().equals(entryId)) {
				iterator.remove();
			}
		}
	}

	public User getUser(String username, String passwordCrypted) {
		return mongoTemplate.findOne(
				new Query(Criteria.where("username").is(user.getUsername())),
				User.class);
	}

}
