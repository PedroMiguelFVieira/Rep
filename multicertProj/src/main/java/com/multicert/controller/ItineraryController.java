package com.multicert.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.multicert.bean.Car;
import com.multicert.bean.ItineraryRequestDetail;
import com.multicert.bean.ItineraryResponse;
import com.multicert.dao.CarDao;
import com.multicert.manager.IItineraryManager;

@Controller
public class ItineraryController {

	private static final Logger logger = LoggerFactory.getLogger(ItineraryController.class);

	@Autowired
	private IItineraryManager service;
	
	/*@Autowired
	private CarJdbcRepository repository;*/
	
	/*@Autowired*/
	private CarDao dao;
	
	
	 @RequestMapping(value = "/req", method = RequestMethod.GET)
	   public ModelAndView user() {
		 ItineraryRequestDetail req = new ItineraryRequestDetail();	  
		  
		  ModelAndView modelAndView = new ModelAndView("req", "command", req);
		  return modelAndView;
	   }
	

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String loginPage(Locale locale, Model model) throws ClassNotFoundException, SQLException {
		logger.info("/index visited.");
		return "index";
	}
	
	
	
	 @ModelAttribute("carsList")
	 public Map<String, String> getCarsList() throws ClassNotFoundException, SQLException {
		 
		 CarDao dao = new CarDao();		
		 List<Car> cars = dao.getAll();
		 
	      Map<String, String> carsList = new HashMap<String, String>();
	      
	      if(cars!=null && !cars.isEmpty()) {
				for(Car car : cars) {
					carsList.put(car.getLicencePlate(), car.getModel());
				}
			}

	      return carsList;
	   }
	

	@RequestMapping(value = "/getInfo", method = {RequestMethod.POST, RequestMethod.GET})
	public String getInfo(@Validated ItineraryRequestDetail itineraryDetail, Model model) {
		logger.info("/getInfo visited.");

		ItineraryResponse response = null;
		try {
			response = this.service.getItineraryInfo(itineraryDetail.getOriginAddress(), itineraryDetail.getDestinationAddress());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			response = new ItineraryResponse();
		}

		model.addAttribute("itineraryInfo", response);
		return "itineraryInfo";
	}
}
