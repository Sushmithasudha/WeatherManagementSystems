package com.weather.controllers;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.models.Weather;
import com.weather.services.WeatherService;

@RestController

@RequestMapping("api/weather")
public class WeatherController {


Logger logger = LoggerFactory.logger(WeatherController.class);
	@Autowired
	private WeatherService service;


	@PostMapping("/addWeatherDetails")
	public ResponseEntity<?> addWeather(@Valid @RequestBody Weather weather) {
		try {
			Weather weatherResponse = service.save(weather);
			logger.info("Add the Weather details| Controller");
			return ResponseEntity.ok(weatherResponse);
		} catch (Exception ex) {
			logger.error("Error During saving the Data ", ex);
			return ResponseEntity.ok("Unable to add Weather Details");
		}
	}

	@PutMapping("{id}")
	public ResponseEntity<?> updateWeather(@PathVariable("id") int id, @Valid @RequestBody Weather weather) {
		try {
			weather.setId(id);
			service.save(weather);
			logger.info("Update the Weather details by id| Controller");
			return ResponseEntity.ok("Updated successfully");
		} catch (Exception ex) {
			logger.error("Error During updating the Weather ", ex);
			return ResponseEntity.ok("Unable to save Weather");
		}
	}

	@GetMapping("/fetchWeatherDetailsByCity")

	public ResponseEntity<?> getAllByCity(String city) {
		logger.info("Get Weather details by City| Controller");
		try {
			List<Weather> weatherlist = service.findByCity(city);
			if (weatherlist.size() > 0) {
				return ResponseEntity.ok(weatherlist);
			} else {
				return ResponseEntity.ok("City may not present!!");
			}

		} catch (Exception ex) {
			logger.error("Error During Fetching the Weather ", ex);
			return ResponseEntity.ok("Unable to Fetching Weather");
		}
	}

	@DeleteMapping("/deleteByCity")
	public ResponseEntity<?> deleteByCity(String city) {
		boolean result = service.deleteData(city);
		logger.info("To delete the Weather details by City");
		if (result) {
			return ResponseEntity.ok("Deleted successfully");
		} else {
			return ResponseEntity.ok("Error in Deletion, May be city is not present");
		}
	}

	@GetMapping("/fetchAllCities")
	public ResponseEntity<?> fetchAllCities() {
		List<Weather> result = service.getAll();
		logger.info("The Weather details by All City");
		if (result.size() > 0) {
			return ResponseEntity.ok(result);
		} else {

			return ResponseEntity.ok("There is no city present");
		}
	}

}
