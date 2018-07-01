package com.multicert.manager;

import com.multicert.bean.ItineraryResponse;

public interface IItineraryManager {

	public ItineraryResponse getItineraryInfo(String originAddress, String destinationAddress);

	
}
