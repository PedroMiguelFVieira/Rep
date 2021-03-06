package com.multicert.manager;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multicert.bean.ItineraryResponse;
import com.multicert.exception.AddressNotFoundException;
import com.multicert.exception.MandatoryFieldsNotFoundException;
import com.multicert.exception.RouteNotFoundException;
import com.multicert.ws.external.bean.MapQuestGeoCodeBean;
import com.multicert.ws.external.bean.MapQuestRouteBean;
import com.multicert.ws.external.bean.ServiceConfigMappingBean;
import com.multicert.ws.external.request.IMapQuestRequestManager;


@Service
public class ItineraryManager implements IItineraryManager {

	private static final Logger logger = LoggerFactory.getLogger(ItineraryManager.class);

	@Autowired
	private IMapQuestRequestManager mapQuestRequestManager;
	
	private final String key = "ugIiekMLl565SzkGIT2vH4TsZmGBMog0";
	
	@Override
	public ItineraryResponse getItineraryInfo(String originAddress, String destinationAddress) {
		
		logger.info("getItineraryInfo started...");
		ItineraryResponse response = new ItineraryResponse();		
		
		
		try{

			if(StringUtils.isEmpty(originAddress) || StringUtils.isEmpty(destinationAddress))
				throw new MandatoryFieldsNotFoundException("Empty mandatory fields");

			
			originAddress = originAddress.replaceAll("\\s+","");
			destinationAddress = destinationAddress.replaceAll("\\s+","");
			
			//Request 1
			ServiceConfigMappingBean mappingBean = new ServiceConfigMappingBean();
			mappingBean.setKey(key);
			mappingBean.setFrom(StringUtils.trim(originAddress));
			mappingBean.setTo(StringUtils.trim(destinationAddress));
			mappingBean.setOutFormat("xml");
			mappingBean.setInFormat("xml");
			mappingBean.setUnit("k");

			MapQuestRouteBean routeInfoBean = this.mapQuestRequestManager.doRouteRequest(mappingBean);		

			response.setDistance(routeInfoBean.getRoute().getDistance());
			response.setDuration(routeInfoBean.getRoute().getFormattedTime());					
			response.setAverateConsumption(routeInfoBean.getRoute().getFuelUsed());
			
			
			//Request 2 Coordenadas da origem
			mappingBean = new ServiceConfigMappingBean();
			mappingBean.setKey(key);
			mappingBean.setLocation(StringUtils.trim(originAddress));
			mappingBean.setOutFormat("xml");
			mappingBean.setInFormat("xml");
			
			MapQuestGeoCodeBean addressInfoBeanOrigin = this.mapQuestRequestManager.doLocationRequest(mappingBean);
			
			
			
			response.setInitialCoordinates(addressInfoBeanOrigin.getResults().get(0).getLocations().get(0).getLatLng().getLat() 
					+ "," + addressInfoBeanOrigin.getResults().get(0).getLocations().get(0).getLatLng().getLng());
			
			
			
			//Request 3 Coordenadas do destino
			mappingBean = new ServiceConfigMappingBean();
			mappingBean.setKey(key);
			mappingBean.setLocation(StringUtils.trim(destinationAddress));			
			mappingBean.setOutFormat("xml");
			mappingBean.setInFormat("xml");
			
			MapQuestGeoCodeBean addressInfoBeanDestination = this.mapQuestRequestManager.doLocationRequest(mappingBean);
					
			
			
			response.setFinalCoordinates(addressInfoBeanDestination.getResults().get(0).getLocations().get(0).getLatLng().getLat() + "," 
			+ addressInfoBeanDestination.getResults().get(0).getLocations().get(0).getLatLng().getLng());
			
		
		} catch (AddressNotFoundException | RouteNotFoundException | MandatoryFieldsNotFoundException e) {
			logger.debug(e.getMessage(), e);
			return response;
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
			return response;
		}

		logger.info("getItineraryInfo ended...");
		return response;	
		
	}
	
	



	
}
