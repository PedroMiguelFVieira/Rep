package com.multicert.ws.external.bean;

public class LocationRouteBean {
	
	
	private String street;	
	private String adminArea5;
	private String adminArea4;
	private String adminArea3; 
	private String postalCode;
	private String adminArea1;
	private String geocodeQuality;
	private String geocodeQualityCode;
	private String dragPoint;
	private String sideOfStreet;
	private DisplayLatLngBean displayLatLng;
	private String linkId;
	private String unknownInput;
	private String type;
	private LatLngBean latLng;
	
	
	public static class DisplayLatLngBean{
		private LatLngBean latLng;

		public LatLngBean getLatLng() {
			return latLng;
		}

		public void setLatLng(LatLngBean latLng) {
			this.latLng = latLng;
		}		
		
	}
	
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

	public String getAdminArea5() {
		return adminArea5;
	}
	public void setAdminArea5(String adminArea5) {
		this.adminArea5 = adminArea5;
	}
	public String getAdminArea4() {
		return adminArea4;
	}
	public void setAdminArea4(String adminArea4) {
		this.adminArea4 = adminArea4;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getAdminArea1() {
		return adminArea1;
	}
	public void setAdminArea1(String adminArea1) {
		this.adminArea1 = adminArea1;
	}
	public String getGeocodeQuality() {
		return geocodeQuality;
	}
	public void setGeocodeQuality(String geocodeQuality) {
		this.geocodeQuality = geocodeQuality;
	}
	public String getGeocodeQualityCode() {
		return geocodeQualityCode;
	}
	public void setGeocodeQualityCode(String geocodeQualityCode) {
		this.geocodeQualityCode = geocodeQualityCode;
	}
	public String getDragPoint() {
		return dragPoint;
	}
	public void setDragPoint(String dragPoint) {
		this.dragPoint = dragPoint;
	}
	public String getSideOfStreet() {
		return sideOfStreet;
	}
	public void setSideOfStreet(String sideOfStreet) {
		this.sideOfStreet = sideOfStreet;
	}

	public String getLinkId() {
		return linkId;
	}
	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}
	public String getUnknownInput() {
		return unknownInput;
	}
	public void setUnknownInput(String unknownInput) {
		this.unknownInput = unknownInput;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LatLngBean getLatLng() {
		return latLng;
	}
	public void setLatLng(LatLngBean latLng) {
		this.latLng = latLng;
	}
	public String getAdminArea3() {
		return adminArea3;
	}
	public void setAdminArea3(String adminArea3) {
		this.adminArea3 = adminArea3;
	}
	public DisplayLatLngBean getDisplayLatLng() {
		return displayLatLng;
	}
	public void setDisplayLatLng(DisplayLatLngBean displayLatLng) {
		this.displayLatLng = displayLatLng;
	}
	
}