package com.multicert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.multicert.bean.ItineraryResponse;
import com.multicert.manager.IItineraryManager;

@Controller
public class ItineraryService {

	@Autowired
	private IItineraryManager itineraryManager;
	
	
	/*private String originAddress;
	private String destinationAddress;
	private Car car;*/
	

	@RequestMapping(value = "/countryInfo/{countryCode}", method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody ItineraryResponse getCountryInfo(@PathVariable String originAddress, String destinationAddress) {
		ItineraryResponse response = new ItineraryResponse();

		try{
			return this.itineraryManager.getItineraryInfo(originAddress, destinationAddress);
		} catch (Exception e) {
			new ItineraryResponse();
		}
		return response;
	}
}