package com.multicert.ws.external.request;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.multicert.exception.AddressNotFoundException;
import com.multicert.exception.RouteNotFoundException;
import com.multicert.ws.external.bean.MapQuestGeoCodeBean;
import com.multicert.ws.external.bean.MapQuestRouteBean;
import com.multicert.ws.external.bean.ServiceConfig;
import com.multicert.ws.external.bean.ServiceConfigMappingBean;
import com.multicert.ws.factory.IServiceConfigType;
import com.multicert.ws.factory.ServiceConfigFactory;
import com.multicert.ws.task.ExternalServiceCaller;
import com.multicert.ws.task.ExternalServiceMapper;

@Service
public class MapQuestRequestManager implements IMapQuestRequestManager {

	private static final Logger logger = LoggerFactory.getLogger(MapQuestRequestManager.class);

	@Override
	public MapQuestRouteBean doRouteRequest(ServiceConfigMappingBean mappingBean) throws RouteNotFoundException {
		
		ServiceConfigFactory serviceConfigFactory = ServiceConfigFactory.getServiceConfigFactory();

		ServiceConfig route = serviceConfigFactory.createServiceConfig(IServiceConfigType.ROUTE,  mappingBean);
		ExternalServiceCaller routeInfoService = new ExternalServiceCaller(route);

		try {
			String routeInfoValue = this.callSingleService(routeInfoService);

			ExternalServiceMapper<MapQuestRouteBean> routeMapper = new ExternalServiceMapper<MapQuestRouteBean>(MapQuestRouteBean.class);
			MapQuestRouteBean routeInfoBean = routeMapper.stringToObject(routeInfoValue);

			if(routeInfoBean.getRoute() == null)
				throw new RouteNotFoundException("Route not found");

			return routeInfoBean;
		} catch (InterruptedException | ExecutionException e) {
			logger.error(e.getMessage(), e);
			return new MapQuestRouteBean();
		} catch (JAXBException e) {
			logger.error(e.getMessage(), e);
			return new MapQuestRouteBean();
		}
	}
	
	
	@Override
	public MapQuestGeoCodeBean doLocationRequest(ServiceConfigMappingBean mappingBean) throws AddressNotFoundException {
		
		ServiceConfigFactory serviceConfigFactory = ServiceConfigFactory.getServiceConfigFactory();

		ServiceConfig address = serviceConfigFactory.createServiceConfig(IServiceConfigType.ADDRESS,  mappingBean);
		ExternalServiceCaller addressInfoService = new ExternalServiceCaller(address);

		try {
			String addressInfoValue = this.callSingleService(addressInfoService);

			ExternalServiceMapper<MapQuestGeoCodeBean> addressMapper = new ExternalServiceMapper<MapQuestGeoCodeBean>(MapQuestGeoCodeBean.class);
			MapQuestGeoCodeBean addressInfoBean = addressMapper.stringToObject(addressInfoValue);

			if(addressInfoBean.getResult() == null)
				throw new AddressNotFoundException("Address not found");

			return addressInfoBean;
		} catch (InterruptedException | ExecutionException e) {
			logger.error(e.getMessage(), e);
			return new MapQuestGeoCodeBean();
		} catch (JAXBException e) {
			logger.error(e.getMessage(), e);
			return new MapQuestGeoCodeBean();
		}
	}
	



	private String callSingleService(Callable<String> task) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<String> result = executor.submit(task);
		executor.shutdown();

		return result.get();
	}

}
