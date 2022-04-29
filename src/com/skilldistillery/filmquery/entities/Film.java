package com.skilldistillery.filmquery.entities;

import java.util.Objects;

public class Film {
	private int id;
	private String title;
	private String description;
	private short releaseYear;
	private int languageId;
	private int rentalDuration;
	private double rate;
	private int length;
	private double replacementCost;
	private String rating;
	private String features;

	public Film() {
		super();
	}

	public Film(int id, String title, String description, short releaseYear, int languageId, int rentalDuration,
			double rate, int length, double replacementCost, String rating, String features) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rate = rate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.features = features;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public short getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(short releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String toString() {
		return "Title: " + this.getTitle() + "\tRelease Year: " + this.getReleaseYear() + "\tRating: "
				+ this.getRating();
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, languageId, length, rating, releaseYear, replacementCost, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(description, other.description) && id == other.id && languageId == other.languageId
				&& length == other.length && Objects.equals(rating, other.rating)
				&& Objects.equals(releaseYear, other.releaseYear)
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(title, other.title);
	}

}
