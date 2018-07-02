package com.multicert.ws.external.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;


@XmlAccessorType(XmlAccessType.FIELD)
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
	
	@XmlElementWrapper(name="streets")
	@XmlElement(name = "street")
	private List<Street> streets;
	
	@XmlElementWrapper(name="signs")
	@XmlElement(name = "sign")
	private List<Sign> signs;
	
	
	private String iconUrl;
	private String linkIds;
	private String mapUrl;



	public static class Sign{
		
		private String type;
		private String direction;
		private String text;
		private String extraText;
		private String url;
		
		
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getDirection() {
			return direction;
		}
		public void setDirection(String direction) {
			this.direction = direction;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public String getExtraText() {
			return extraText;
		}
		public void setExtraText(String extraText) {
			this.extraText = extraText;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		
	}

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








	public List<Street> getStreets() {
		return streets;
	}





	public void setStreets(List<Street> streets) {
		this.streets = streets;
	}




	public List<Sign> getSigns() {
		return signs;
	}





	public void setSigns(List<Sign> signs) {
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
