package com.weather.services;

import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.models.Weather;
import com.weather.repository.WeatherRepository;

@Service
public class WeatherService {
	org.jboss.logging.Logger logger = LoggerFactory.logger(WeatherService.class);

	@Autowired
	private WeatherRepository repo;

	public Weather save(Weather we) {
		logger.info("To save the Weather details");
		return repo.save(we);
	}

	public Weather getById(int id) {
		logger.info("Get Weather details by id");
		return repo.getById(id);
	}

	public List<Weather> getAll() {
		logger.info("Fetching all the Weather details");
		return repo.findAll();
	}

	public List<Weather> findByCity(String city) {
		logger.info("Get Weather details by City");
		return repo.findByCity(city);
	}

	public boolean deleteData(String city) {
		logger.info("To delete the Weather details by City");
		boolean result = false;
		try {
			List<Weather> data = repo.findByCity(city);
			if (data.size() > 0) {
				repo.deleteAll(data);
				result = true;
			} else {
				result = false;
			}

		} catch (Exception e) {
			logger.error("error in deleting data : ", e);
		}
		return result;
	}
}
