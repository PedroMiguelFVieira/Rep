package com.multicert.controller;

import java.sql.SQLException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.multicert.bean.ItineraryRequestDetail;
import com.multicert.bean.ItineraryResponse;
import com.multicert.manager.IItineraryManager;

@Controller
public class ItineraryController {

	private static final Logger logger = LoggerFactory.getLogger(ItineraryController.class);

	@Autowired
	private IItineraryManager service;
	
	/*@Autowired
	private CarJdbcRepository repository;*/
	
	/*@Autowired
	private CarDao dao;*/
	

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String loginPage(Locale locale, Model model) throws ClassNotFoundException, SQLException {
		logger.info("/index visited.");
		
		
		
		/*List <Car> carList = repository.findAll();		
		System.out.println(carList);*/
		/*CarDao dao = new CarDao();		
		
		ModelAndView mav = new ModelAndView("infoForm");
		List<Car> cars = dao.getAll(); */
		/*Map< String, String > carsMap = new HashMap<String, String>();
		carsMap.put("opel", "OPEL");
		carsMap.put("nissan", "NISSAN");
		carsMap.put("mercedes", "MERCEDES");
		carsMap.put("bmw", "BMW");        
        mav.addObject("carsMap", carsMap);*/
        

		return "index";
	}

	@RequestMapping(value = "/getInfo", method = {RequestMethod.POST, RequestMethod.GET})
	public String login(@Validated ItineraryRequestDetail itineraryDetail, Model model) {
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
