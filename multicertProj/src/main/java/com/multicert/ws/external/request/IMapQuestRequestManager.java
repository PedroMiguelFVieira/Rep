package com.multicert.ws.external.request;

import com.multicert.exception.AddressNotFoundException;
import com.multicert.ws.external.bean.MapQuestGeoCodeBean;
import com.multicert.ws.external.bean.MapQuestRouteBean;
import com.multicert.ws.external.bean.ServiceConfigMappingBean;

public interface IMapQuestRequestManager {

	public MapQuestRouteBean doRouteRequest(ServiceConfigMappingBean mappingBean) throws Exception;
	
	public MapQuestGeoCodeBean doLocationRequest(ServiceConfigMappingBean mappingBean) throws AddressNotFoundException;

	
}
