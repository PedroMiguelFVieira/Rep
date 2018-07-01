package com.multicert.ws.external.bean;

import java.util.List;

public class ResultBean {
	
	
	private ProvidedLocationBean providedLocation;
	private List<LocationBean> locations;
	
	
	
	public static class ProvidedLocationBean {
		
		private String location;

		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		
		
	}
	
	public ProvidedLocationBean getProvidedLocation() {
		return providedLocation;
	}
	public void setProvidedLocation(ProvidedLocationBean providedLocation) {
		this.providedLocation = providedLocation;
	}
	public List<LocationBean> getLocations() {
		return locations;
	}
	public void setLocations(List<LocationBean> locations) {
		this.locations = locations;
	}

		


}
