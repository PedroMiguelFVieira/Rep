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

			if(StringUtils.isBlank(originAddress) || StringUtils.isBlank(destinationAddress))
				throw new MandatoryFieldsNotFoundException("Empty mandatory fields");

			//Request 1
			ServiceConfigMappingBean mappingBean = new ServiceConfigMappingBean();
			mappingBean.setKey(key);
			mappingBean.setFrom(originAddress);
			mappingBean.setTo(destinationAddress);

			MapQuestRouteBean routeInfoBean = this.mapQuestRequestManager.doRouteRequest(mappingBean);		

			response.setDistance(Integer.parseInt(routeInfoBean.getRoute().getDistance()));
			response.setDuration(routeInfoBean.getRoute().getTime());
			response.setAverateConsumption(Integer.parseInt(routeInfoBean.getRoute().getFuelUsed()));
			
			
			//Request 2
			mappingBean = new ServiceConfigMappingBean();
			mappingBean.setKey(key);
			mappingBean.setLocation(originAddress);			
			
			MapQuestGeoCodeBean addressInfoBeanOrigin = this.mapQuestRequestManager.doLocationRequest(mappingBean);
			
			response.setInitialCoordinates(addressInfoBeanOrigin.getResult().getLocation().getLatLng().getLat() + "," + addressInfoBeanOrigin.getResult().getLocation().getLatLng().getLng());
			
			
			
			//Request 3
			mappingBean = new ServiceConfigMappingBean();
			mappingBean.setKey(key);
			mappingBean.setLocation(destinationAddress);			
			
			MapQuestGeoCodeBean addressInfoBeanDestination = this.mapQuestRequestManager.doLocationRequest(mappingBean);
			response.setFinalCoordinates(addressInfoBeanDestination.getResult().getLocation().getLatLng().getLat() + "," + addressInfoBeanDestination.getResult().getLocation().getLatLng().getLng());
			
		
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
