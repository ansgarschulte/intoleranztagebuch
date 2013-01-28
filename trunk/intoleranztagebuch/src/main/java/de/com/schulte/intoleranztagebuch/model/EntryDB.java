package de.com.schulte.intoleranztagebuch.model;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.vaadin.data.Container;
import com.vaadin.data.util.IndexedContainer;

import de.com.schulte.intoleranztagebuch.util.Translations;

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

	public Container getDiscomforts(Locale locale) {
		IndexedContainer indexedContainer = new IndexedContainer(
				getAllDiscomforts());
		indexedContainer.addContainerProperty("lang", String.class, "");
		ResourceBundle tr = Translations.get(locale);

		for (int i = 0; i < getAllDiscomforts().size(); i++) {
			String idByIndex = (String) indexedContainer.getIdByIndex(i);
			indexedContainer.getItem(idByIndex).getItemProperty("lang")
					.setValue(tr.getString(idByIndex));
		}

		return indexedContainer;
	}

	private List<String> getAllDiscomforts() {
		List<String> discomforts = new ArrayList<String>();
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

	public void persist(Entry entry) {
		user.getEntries().add(entry);
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

}
