package com.multicert.ws.external.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class MapQuestGeoCodeBean extends AbstractMapQuestRouteBean {

	private static final long serialVersionUID = 1L;	
	
	@XmlElement(name = "info")
	private InfoBean info;
	
	@XmlElement(name = "results")
	private List<ResultBean> results;

	
	@XmlElement(name = "options")
	private OptionsBean options;
	
	
	public InfoBean getInfo() {
		return info;
	}


	public void setInfo(InfoBean info) {
		this.info = info;
	}



	public List<ResultBean> getResults() {
		return results;
	}


	public void setResults(List<ResultBean> results) {
		this.results = results;
	}


	public OptionsBean getOptions() {
		return options;
	}


	public void setOptions(OptionsBean options) {
		this.options = options;
	}




	
}
