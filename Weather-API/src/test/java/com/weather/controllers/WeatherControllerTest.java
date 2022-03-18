package com.weather.controllers;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.weather.Utility.RequestResponseGenerator;
import com.weather.models.Weather;
import com.weather.repository.WeatherRepository;
import com.weather.services.WeatherService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = WeatherController.class)
@ContextConfiguration(classes = WeatherRepository.class)
@SuppressWarnings("all")	
public class WeatherControllerTest {
	Logger logger = LoggerFactory.logger(WeatherControllerTest.class);

	@InjectMocks
	private WeatherController weatherController;

	@Mock
	private WeatherService service;

	private Weather weather = null;

	@BeforeEach
	public void init() {
		System.out.println("Initilazition started!!!");
		logger.info("Initilazition started!!!");

		weather = RequestResponseGenerator.createWeatherObject();
	}

	@Test

	public void testAddWeather() throws Exception {
		Mockito.when(service.save(Mockito.any(Weather.class))).thenReturn(weather);
		ResponseEntity<Weather> response = (ResponseEntity<Weather>) weatherController.addWeather(weather);
		Assert.assertEquals(response.getStatusCodeValue(), 200);
	}

	@Test
	//public void testSaveWeatherWhenError() throws Exception {
	public void testAddWeatherWhenError() throws Exception {
		Mockito.when(service.save(Mockito.any(Weather.class))).thenThrow(NullPointerException.class);
		ResponseEntity<Weather> response = (ResponseEntity<Weather>) weatherController.addWeather(weather);
		Assert.assertEquals(response.getStatusCodeValue(), 200);
	}

	@Test
	public void testUpdateWeather() {
		Mockito.when(service.save(Mockito.any(Weather.class))).thenReturn(weather);
		ResponseEntity<Weather> response = (ResponseEntity<Weather>) weatherController.updateWeather(1, weather);
		Assert.assertEquals(response.getStatusCodeValue(), 200);
	}

	@Test
	public void testUpdateWeatherWhenError() {
		Mockito.when(service.save(Mockito.any(Weather.class))).thenThrow(NullPointerException.class);
		ResponseEntity<Weather> response = (ResponseEntity<Weather>) weatherController.updateWeather(1, weather);
		Assert.assertEquals(response.getStatusCodeValue(), 200);
	}

	/*@Test
	public void testGetAllByCity() {
		Mockito.when(service.findByCity(Mockito.anyString()))
				.thenReturn(RequestResponseGenerator.createWeatherObjectList("Mumbai"));
		ResponseEntity<Weather> response = (ResponseEntity<Weather>) weatherController.getAllByCity("Mumbai");
		Assert.assertEquals(200, response.getStatusCodeValue());
	}	

	@Test
	public void testGetAllByCityWhenError() {
		Mockito.when(service.findByCity(Mockito.anyString())).thenThrow(NullPointerException.class);
		ResponseEntity<Weather> response = (ResponseEntity<Weather>) weatherController.getAllByCity("Mumbai");
		Assert.assertEquals(response.getStatusCodeValue(), 200);
	} */

	@Test
	public void testDeleteByCity() {
		Mockito.when(service.deleteData(Mockito.anyString())).thenReturn(true);
		ResponseEntity<Weather> response = (ResponseEntity<Weather>) weatherController.deleteByCity("Mumbai");
		Assert.assertEquals(response.getStatusCodeValue(), 200);
	}

	@Test
	public void testDeleteByCityWhenError() {
		Mockito.when(service.deleteData(Mockito.anyString())).thenReturn(false);
		ResponseEntity<Weather> response = (ResponseEntity<Weather>) weatherController.deleteByCity("Mumbai");
		Assert.assertEquals(response.getStatusCodeValue(), 200);
	}

}
