package com.multicert.ws.external.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public class RouteBean {

	private String sessionId;
	private Options options;
	private BoundingBox boundingBox;
	private String distance;
	private String time;
	private String realTime;
	private String fuelUsed;
	private String formattedTime;
	
	@XmlElementWrapper(name="legs")
	@XmlElement(name = "leg")
	private List<LegBean> legs;
	
	
	private String hasTollRoad;
	private String hasFerry;
	private String hasHighway;
	private String hasSeasonalClosure;
	private String hasUnpaved;
	private String hasCountryCross;
	
	
	@XmlElementWrapper(name="locations")
	@XmlElement(name = "location")
	private List<LocationRouteBean> locations;
	
	
	private String locationSequence;
	private String computedWaypoints;
	
	
	
	public static class Options{
		private String shapeFormat;
		private String generalize;
		private String maxLinkId;
		private String narrativeType;
		private String stateBoundaryDisplay;
		private String countryBoundaryDisplay;
		private String sideOfStreetDisplay;
		private String destinationManeuverDisplay;
		private String avoidTimedConditions;
		private String enhancedNarrative;
		private String returnLinkDirections;
		private String timeType;
		private String routeType;
		private String locale;
		private String unit;
		private String tryAvoidLinkIds;
		private String mustAvoidLinkIds;
		private String manmaps;
		private String drivingStyle;
		private String highwayEfficiency;
		private String useTraffic;
		
		
		public String getShapeFormat() {
			return shapeFormat;
		}
		public void setShapeFormat(String shapeFormat) {
			this.shapeFormat = shapeFormat;
		}
		public String getGeneralize() {
			return generalize;
		}
		public void setGeneralize(String generalize) {
			this.generalize = generalize;
		}
		public String getMaxLinkId() {
			return maxLinkId;
		}
		public void setMaxLinkId(String maxLinkId) {
			this.maxLinkId = maxLinkId;
		}
		public String getNarrativeType() {
			return narrativeType;
		}
		public void setNarrativeType(String narrativeType) {
			this.narrativeType = narrativeType;
		}
		public String getStateBoundaryDisplay() {
			return stateBoundaryDisplay;
		}
		public void setStateBoundaryDisplay(String stateBoundaryDisplay) {
			this.stateBoundaryDisplay = stateBoundaryDisplay;
		}
		public String getCountryBoundaryDisplay() {
			return countryBoundaryDisplay;
		}
		public void setCountryBoundaryDisplay(String countryBoundaryDisplay) {
			this.countryBoundaryDisplay = countryBoundaryDisplay;
		}
		public String getSideOfStreetDisplay() {
			return sideOfStreetDisplay;
		}
		public void setSideOfStreetDisplay(String sideOfStreetDisplay) {
			this.sideOfStreetDisplay = sideOfStreetDisplay;
		}
		public String getDestinationManeuverDisplay() {
			return destinationManeuverDisplay;
		}
		public void setDestinationManeuverDisplay(String destinationManeuverDisplay) {
			this.destinationManeuverDisplay = destinationManeuverDisplay;
		}
		public String getAvoidTimedConditions() {
			return avoidTimedConditions;
		}
		public void setAvoidTimedConditions(String avoidTimedConditions) {
			this.avoidTimedConditions = avoidTimedConditions;
		}
		public String getEnhancedNarrative() {
			return enhancedNarrative;
		}
		public void setEnhancedNarrative(String enhancedNarrative) {
			this.enhancedNarrative = enhancedNarrative;
		}
		public String getReturnLinkDirections() {
			return returnLinkDirections;
		}
		public void setReturnLinkDirections(String returnLinkDirections) {
			this.returnLinkDirections = returnLinkDirections;
		}
		public String getTimeType() {
			return timeType;
		}
		public void setTimeType(String timeType) {
			this.timeType = timeType;
		}
		public String getRouteType() {
			return routeType;
		}
		public void setRouteType(String routeType) {
			this.routeType = routeType;
		}
		public String getLocale() {
			return locale;
		}
		public void setLocale(String locale) {
			this.locale = locale;
		}
		public String getUnit() {
			return unit;
		}
		public void setUnit(String unit) {
			this.unit = unit;
		}
		public String getTryAvoidLinkIds() {
			return tryAvoidLinkIds;
		}
		public void setTryAvoidLinkIds(String tryAvoidLinkIds) {
			this.tryAvoidLinkIds = tryAvoidLinkIds;
		}
		public String getMustAvoidLinkIds() {
			return mustAvoidLinkIds;
		}
		public void setMustAvoidLinkIds(String mustAvoidLinkIds) {
			this.mustAvoidLinkIds = mustAvoidLinkIds;
		}
		public String getManmaps() {
			return manmaps;
		}
		public void setManmaps(String manmaps) {
			this.manmaps = manmaps;
		}
		public String getDrivingStyle() {
			return drivingStyle;
		}
		public void setDrivingStyle(String drivingStyle) {
			this.drivingStyle = drivingStyle;
		}
		public String getHighwayEfficiency() {
			return highwayEfficiency;
		}
		public void setHighwayEfficiency(String highwayEfficiency) {
			this.highwayEfficiency = highwayEfficiency;
		}
		public String getUseTraffic() {
			return useTraffic;
		}
		public void setUseTraffic(String useTraffic) {
			this.useTraffic = useTraffic;
		}
		
		
		
	}
	
	
	public static class BoundingBox{
		private Coord ul;
		private Coord lr;
			
		
		public Coord getUl() {
			return ul;
		}
		public void setUl(Coord ul) {
			this.ul = ul;
		}

		public Coord getLr() {
			return lr;
		}
		public void setLr(Coord lr) {
			this.lr = lr;
		}

		public static class Coord{
			private String lat;
			private String lng;
			
			public String getLat() {
				return lat;
			}
			public void setLat(String lat) {
				this.lat = lat;
			}
			public String getLng() {
				return lng;
			}
			public void setLng(String lng) {
				this.lng = lng;
			}
			
		}
		
	}
	
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	


	public BoundingBox getBoundingBox() {
		return boundingBox;
	}
	public void setBoundingBox(BoundingBox boundingBox) {
		this.boundingBox = boundingBox;
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
	public String getRealTime() {
		return realTime;
	}
	public void setRealTime(String realTime) {
		this.realTime = realTime;
	}
	public String getFuelUsed() {
		return fuelUsed;
	}
	public void setFuelUsed(String fuelUsed) {
		this.fuelUsed = fuelUsed;
	}
	public String getFormattedTime() {
		return formattedTime;
	}
	public void setFormattedTime(String formattedTime) {
		this.formattedTime = formattedTime;
	}

	public String getHasTollRoad() {
		return hasTollRoad;
	}
	public void setHasTollRoad(String hasTollRoad) {
		this.hasTollRoad = hasTollRoad;
	}
	public String getHasFerry() {
		return hasFerry;
	}
	public void setHasFerry(String hasFerry) {
		this.hasFerry = hasFerry;
	}
	public String getHasHighway() {
		return hasHighway;
	}
	public void setHasHighway(String hasHighway) {
		this.hasHighway = hasHighway;
	}
	public String getHasSeasonalClosure() {
		return hasSeasonalClosure;
	}
	public void setHasSeasonalClosure(String hasSeasonalClosure) {
		this.hasSeasonalClosure = hasSeasonalClosure;
	}
	public String getHasUnpaved() {
		return hasUnpaved;
	}
	public void setHasUnpaved(String hasUnpaved) {
		this.hasUnpaved = hasUnpaved;
	}
	public String getHasCountryCross() {
		return hasCountryCross;
	}
	public void setHasCountryCross(String hasCountryCross) {
		this.hasCountryCross = hasCountryCross;
	}

	public String getLocationSequence() {
		return locationSequence;
	}
	public void setLocationSequence(String locationSequence) {
		this.locationSequence = locationSequence;
	}
	public String getComputedWaypoints() {
		return computedWaypoints;
	}
	public void setComputedWaypoints(String computedWaypoints) {
		this.computedWaypoints = computedWaypoints;
	}

	public Options getOptions() {
		return options;
	}
	public void setOptions(Options options) {
		this.options = options;
	}
	public List<LegBean> getLegs() {
		return legs;
	}
	public void setLegs(List<LegBean> legs) {
		this.legs = legs;
	}
	public List<LocationRouteBean> getLocations() {
		return locations;
	}
	public void setLocations(List<LocationRouteBean> locations) {
		this.locations = locations;
	}
	

}
