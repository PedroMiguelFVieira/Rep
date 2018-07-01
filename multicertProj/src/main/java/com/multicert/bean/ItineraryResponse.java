package com.multicert.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItineraryResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	
	private String initialCoordinates;
	private String finalCoordinates;
	private String distance;
	private String duration;
	private String averateConsumption;
	
	
	
	
	public String getInitialCoordinates() {
		return initialCoordinates;
	}
	public void setInitialCoordinates(String initialCoordinates) {
		this.initialCoordinates = initialCoordinates;
	}
	public String getFinalCoordinates() {
		return finalCoordinates;
	}
	public void setFinalCoordinates(String finalCoordinates) {
		this.finalCoordinates = finalCoordinates;
	}

	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getAverateConsumption() {
		return averateConsumption;
	}
	public void setAverateConsumption(String averateConsumption) {
		this.averateConsumption = averateConsumption;
	}





}
