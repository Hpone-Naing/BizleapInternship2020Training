package com.bizleap.marchant.domain.enums;

public enum SeasonCategory {

	SUMMER("Summer"), RAINING("Raining"), WINTER("Winter");
	
	private String season;

	private SeasonCategory(String season) {
		this.season = season;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}
}