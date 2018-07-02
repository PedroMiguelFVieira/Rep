package com.multicert.ws.factory;

import java.util.HashMap;
import java.util.Map;

import com.multicert.ws.external.bean.ServiceConfig;
import com.multicert.ws.external.bean.ServiceConfigMappingBean;

public class ServiceConfigFactory {

	private static ServiceConfigFactory instance;
	
	private static final String MAP_QUEST_URL_GEO = "geocoding/v1/";
	private static final String MAP_QUEST_URL_DIRECTIONS = "directions/v2/";
	

	private ServiceConfigFactory(){}

	public static ServiceConfigFactory getServiceConfigFactory(){
		if(instance == null){
			synchronized (ServiceConfigFactory.class){
				if(instance == null){
					instance = new ServiceConfigFactory();
					}
				}
			}
		return instance;
	}

	public ServiceConfig createServiceConfig(IServiceConfigType configType, ServiceConfigMappingBean mappingBean){
		if(IServiceConfigType.ROUTE.equals(configType)){
			
			ServiceConfig serviceConfig = new ServiceConfig();

			Map<String, String> params = new HashMap<String,String>();
			params.put("key", mappingBean.getKey());
			params.put("from", mappingBean.getFrom());	
			params.put("to", mappingBean.getTo());
			params.put("outFormat", mappingBean.getOutFormat());
			params.put("unit", mappingBean.getUnit());
			

			serviceConfig.setHost(configType.getMethod());
			serviceConfig.setUrlPart(MAP_QUEST_URL_DIRECTIONS);
			serviceConfig.setParams(params);
			return serviceConfig;
			
		}else if(IServiceConfigType.ADDRESS.equals(configType)){
			
			ServiceConfig serviceConfig = new ServiceConfig();

			Map<String, String> params = new HashMap<String,String>();
			params.put("key", mappingBean.getKey());
			params.put("outFormat", mappingBean.getOutFormat());
			params.put("location", mappingBean.getLocation());
			
			
			serviceConfig.setHost(configType.getMethod());
			serviceConfig.setUrlPart(MAP_QUEST_URL_GEO);
			serviceConfig.setParams(params);
			return serviceConfig;
		}		
		
		return null;
	}
}
