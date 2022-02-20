package com.weather.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weather.models.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {

	List<Weather> findByCity(String city);
	
}
