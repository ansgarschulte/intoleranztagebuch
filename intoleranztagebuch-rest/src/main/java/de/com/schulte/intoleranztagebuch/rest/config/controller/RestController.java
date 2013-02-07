package de.com.schulte.intoleranztagebuch.rest.config.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.com.schulte.intoleranztagebuch.model.Entry;
import de.com.schulte.intoleranztagebuch.model.EntryDB;
import de.com.schulte.intoleranztagebuch.model.User;

@Controller
public class RestController {

	private static final Log LOG = LogFactory.getLog(RestController.class);

	@Autowired
	private EntryDB entryDB;

	@RequestMapping(value = "/getAllEntries", method = RequestMethod.GET)
	@ResponseBody
	public List<Entry> getAllEntries(@RequestParam("userId") String userId) {
		User user = entryDB.login("karin", "karin");
		List<Entry> allEntries = entryDB.getAllEntries();
		System.out.println("test");
		return allEntries;
	}
	// @RequestMapping(value = "/getAllEntries", method = RequestMethod.GET)
	// @ResponseBody
	// public String getAllEntries(
	// @RequestParam("deviceTyp") String deviceTyp,
	// @RequestParam("latitude") double latitude,
	// @RequestParam("longitude") double longitude,
	// @RequestParam("name") String name,
	// @RequestParam("insurerId") int insurerId,
	// @RequestParam("typ") int typ,
	// @RequestParam(required = false, defaultValue = "-1") int configInsurerId)
	// {
	// return "Hallo";
	// }

}
