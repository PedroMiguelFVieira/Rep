package com.multicert.ws.external.bean;

public class OptionsBean {

	private String maxResults;
	private String thumbMaps;
	private String ignoreLatLngInput;
	private String boundingBox;
	
	
	public String getMaxResults() {
		return maxResults;
	}
	public void setMaxResults(String maxResults) {
		this.maxResults = maxResults;
	}
	public String getThumbMaps() {
		return thumbMaps;
	}
	public void setThumbMaps(String thumbMaps) {
		this.thumbMaps = thumbMaps;
	}
	public String getIgnoreLatLngInput() {
		return ignoreLatLngInput;
	}
	public void setIgnoreLatLngInput(String ignoreLatLngInput) {
		this.ignoreLatLngInput = ignoreLatLngInput;
	}
	public String getBoundingBox() {
		return boundingBox;
	}
	public void setBoundingBox(String boundingBox) {
		this.boundingBox = boundingBox;
	}
	
}
