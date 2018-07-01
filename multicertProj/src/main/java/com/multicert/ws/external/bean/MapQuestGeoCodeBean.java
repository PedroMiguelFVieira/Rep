package com.multicert.ws.external.bean;

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
	
	
	@XmlElement(name = "options")
	private OptionsBean option;
	

	@XmlElement(name = "results")
	private ResultBean result;

	
	public InfoBean getInfo() {
		return info;
	}


	public void setInfo(InfoBean info) {
		this.info = info;
	}


	public OptionsBean getOption() {
		return option;
	}


	public void setOption(OptionsBean option) {
		this.option = option;
	}


	public ResultBean getResult() {
		return result;
	}


	public void setResult(ResultBean result) {
		this.result = result;
	}

	
}
