package com.multicert;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.multicert.bean.ItineraryResponse;
import com.multicert.manager.IItineraryManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/servlet-context.xml", "/root-context.xml"})
public class TestServiceResponse {

	@Autowired
	private IItineraryManager itineraryManager;

	@Test
	public void testEmptyRequest() {
		try {
			ItineraryResponse response = this.itineraryManager.getItineraryInfo("", "");
			Assert.assertNull(response.getDuration());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testInvalidLocations() {
		try {
			ItineraryResponse response = this.itineraryManager.getItineraryInfo("12345","blablala");
			Assert.assertNull(response.getDuration());
			Assert.assertNull(response.getFinalCoordinates());
			Assert.assertNull(response.getInitialCoordinates());
			Assert.assertNull(response.getAverateConsumption());
						
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testValidLocation() {
		try {
			ItineraryResponse response = this.itineraryManager.getItineraryInfo("Lisbon,Portugal","Porto,Portugal");
			Assert.assertNotNull(response.getDuration());
			Assert.assertNotNull(response.getFinalCoordinates());
			Assert.assertNotNull(response.getInitialCoordinates());
			Assert.assertNotNull(response.getAverateConsumption());			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
}
