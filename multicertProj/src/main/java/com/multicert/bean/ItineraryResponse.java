package com.multicert.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItineraryResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	
	private String initialCoordinates;
	private String finalCoordinates;
	private int distance;
	private String duration;
	private int averateConsumption;
	
	
	
	
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
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getAverateConsumption() {
		return averateConsumption;
	}
	public void setAverateConsumption(int averateConsumption) {
		this.averateConsumption = averateConsumption;
	}




}
