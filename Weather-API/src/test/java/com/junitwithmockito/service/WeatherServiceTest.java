package com.junitwithmockito.service;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.junitwithmockito.Utility.RequestResponseGenerator;
import com.junitwithmockito.models.Weather;
import com.junitwithmockito.repository.WeatherRepository;
import com.junitwithmockito.services.WeatherService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = WeatherServiceTest.class)
@SuppressWarnings("all")
public class WeatherServiceTest {

	@InjectMocks
	private WeatherService service;

	@Mock
	private WeatherRepository repository;

	private Weather weather = null;

	@BeforeEach
	public void init() {
		weather = RequestResponseGenerator.createWeatherObject();
	}

	@Test
	public void testSave() {
		Mockito.when(repository.save(Mockito.any(Weather.class))).thenReturn(weather);
		Weather weatherResponse = service.save(weather);
		Assert.assertNotNull(weatherResponse);
	}

	@Test
	public void testfindByCity() {
		String city = "Mumbai";
		Mockito.when(repository.findByCity(Mockito.anyString()))
				.thenReturn(RequestResponseGenerator.createWeatherObjectList(city));
		List<Weather> weatherResult = service.findByCity(city);
		Assert.assertNotNull(weatherResult);
	}

	@Test
	public void testdeleteData() {
		String city = "Mumbai";
		Mockito.when(repository.findByCity(Mockito.anyString()))
				.thenReturn(RequestResponseGenerator.createWeatherObjectList(city));
		Mockito.doNothing().when(repository).deleteAll(Mockito.anyList());
		boolean weatherResult = service.deleteData(city);
		Assert.assertTrue(weatherResult);
	}

	@Test
	public void testdeleteDataWhenError() {
		String city = "Mumbai";
		Mockito.when(repository.findByCity(Mockito.anyString())).thenThrow(NullPointerException.class);
		boolean weatherResult = service.deleteData(city);
		Assert.assertFalse(weatherResult);
	}
	@Test
	public void testgetAll() {
		Mockito.when(repository.findAll()).thenReturn(RequestResponseGenerator.createWeatherResponseList());
		List<Weather> weatherResult = service.getAll();
		Assert.assertNotNull(weatherResult);
	}

}
