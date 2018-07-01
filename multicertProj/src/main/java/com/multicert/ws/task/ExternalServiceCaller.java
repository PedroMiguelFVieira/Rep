package com.multicert.ws.task;

import java.io.IOException;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.multicert.ws.external.bean.ServiceConfig;
import com.multicert.ws.external.http.HttpGetConnection;

public class ExternalServiceCaller implements Callable<String>{

	private static final Logger logger = LoggerFactory.getLogger(ExternalServiceCaller.class);
	
	//private static final String MAP_QUEST_URL = "http://www.mapquestapi.com/directions/v2/";
	private static final String MAP_QUEST_URL = "http://www.mapquestapi.com/";
	
	
	
	
	private ServiceConfig serviceConfig;

	public ExternalServiceCaller(ServiceConfig serviceConfig) {
		this.serviceConfig = serviceConfig;
	}

	@Override
	public String call() throws IOException {
		String url = this.buildUrl();
		HttpGetConnection httpConn = new HttpGetConnection();
		StringBuilder response = httpConn.sendGet(this.buildUrl());

		logger.info("MapQuestService called, service: " + url);
		return response.toString();
	}


	private String buildUrl(){
		StringBuilder url = new StringBuilder(ExternalServiceCaller.MAP_QUEST_URL);

		url.append("/" + this.serviceConfig.getUrlPart() + "/" + this.serviceConfig.getHost());

		String separator = "?";
		for(String key : this.serviceConfig.getParams().keySet()){
			url.append(separator + key + "=" + this.serviceConfig.getParams().get(key));
			separator = "&";
		}
		return url.toString();
	}
}