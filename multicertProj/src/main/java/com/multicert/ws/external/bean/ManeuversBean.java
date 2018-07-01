package com.multicert.ws.external.bean;

public class ManeuversBean {


	private LatLngBean startPoint;
	private String maneuverNotes;
	private String distance;
	private String time;
	private String formattedTime;
	private String attributes;
	private String turnType;
	private String direction;
	private String narrative;
	private String directionName;
	private String index;
	private Street streets;
	private String signs;
	private String iconUrl;
	private String linkIds;
	private String mapUrl;





	public static class Street {
		private String street;

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}		

	}





	public LatLngBean getStartPoint() {
		return startPoint;
	}





	public void setStartPoint(LatLngBean startPoint) {
		this.startPoint = startPoint;
	}





	public String getManeuverNotes() {
		return maneuverNotes;
	}





	public void setManeuverNotes(String maneuverNotes) {
		this.maneuverNotes = maneuverNotes;
	}





	public String getDistance() {
		return distance;
	}





	public void setDistance(String distance) {
		this.distance = distance;
	}





	public String getTime() {
		return time;
	}





	public void setTime(String time) {
		this.time = time;
	}





	public String getFormattedTime() {
		return formattedTime;
	}





	public void setFormattedTime(String formattedTime) {
		this.formattedTime = formattedTime;
	}





	public String getAttributes() {
		return attributes;
	}





	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}





	public String getTurnType() {
		return turnType;
	}





	public void setTurnType(String turnType) {
		this.turnType = turnType;
	}





	public String getDirection() {
		return direction;
	}





	public void setDirection(String direction) {
		this.direction = direction;
	}





	public String getNarrative() {
		return narrative;
	}





	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}





	public String getDirectionName() {
		return directionName;
	}





	public void setDirectionName(String directionName) {
		this.directionName = directionName;
	}





	public String getIndex() {
		return index;
	}





	public void setIndex(String index) {
		this.index = index;
	}





	public Street getStreets() {
		return streets;
	}





	public void setStreets(Street streets) {
		this.streets = streets;
	}





	public String getSigns() {
		return signs;
	}





	public void setSigns(String signs) {
		this.signs = signs;
	}





	public String getIconUrl() {
		return iconUrl;
	}





	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}





	public String getLinkIds() {
		return linkIds;
	}





	public void setLinkIds(String linkIds) {
		this.linkIds = linkIds;
	}





	public String getMapUrl() {
		return mapUrl;
	}





	public void setMapUrl(String mapUrl) {
		this.mapUrl = mapUrl;
	}



}
