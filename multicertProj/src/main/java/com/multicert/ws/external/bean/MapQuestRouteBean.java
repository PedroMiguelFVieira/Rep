package com.multicert.ws.external.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class MapQuestRouteBean extends AbstractMapQuestRouteBean {

	private static final long serialVersionUID = 1L;	
	
	@XmlElement(name = "info")
	private InfoBean info;
	
	
	@XmlElement(name = "routeError")
	private RouteErrorBean routeError;
	

	@XmlElement(name = "route")
	private RouteBean route;


	public InfoBean getInfo() {
		return info;
	}


	public void setInfo(InfoBean info) {
		this.info = info;
	}


	public RouteErrorBean getRouteError() {
		return routeError;
	}


	public void setRouteError(RouteErrorBean routeError) {
		this.routeError = routeError;
	}


	public RouteBean getRoute() {
		return route;
	}


	public void setRoute(RouteBean route) {
		this.route = route;
	}
	
}
