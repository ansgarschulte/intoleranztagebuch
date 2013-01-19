package de.com.schulte.intoleranztagebuch.model;

import java.util.Date;

public class Entry {

	private Date eatTime;
	private String meal;
	private String drink;
	private Date discomfortTime;
	private String discomforts;
	private String supposedCause;

	public Entry(Date eatTime, String meal, String drink) {
		super();
		this.eatTime = eatTime;
		this.meal = meal;
		this.drink = drink;
	}

	public Entry(Date eatTime, String meal, String drink, Date discomfortTime,
			String discomforts, String supposedCause) {
		super();
		this.eatTime = eatTime;
		this.meal = meal;
		this.drink = drink;
		this.discomfortTime = discomfortTime;
		this.discomforts = discomforts;
		this.supposedCause = supposedCause;
	}

	public Entry() {
		super();
		this.eatTime = new Date();
		this.meal = "";
		this.drink = "";
		this.discomfortTime = null;
		this.discomforts = "";
		this.supposedCause = "";
	}

	public Date getEatTime() {
		return eatTime;
	}

	public void setEatTime(Date eatTime) {
		this.eatTime = eatTime;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public Date getDiscomfortTime() {
		return discomfortTime;
	}

	public void setDiscomfortTime(Date discomfortTime) {
		this.discomfortTime = discomfortTime;
	}

	public String getDiscomforts() {
		return discomforts;
	}

	public void setDiscomforts(String discomforts) {
		this.discomforts = discomforts;
	}

	public String getSupposedCause() {
		return supposedCause;
	}

	public void setSupposedCause(String supposedCause) {
		this.supposedCause = supposedCause;
	}

}
