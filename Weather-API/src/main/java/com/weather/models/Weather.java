package com.weather.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Weather {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "City must be given")
	@Pattern(regexp="[A-Z][A-Za-z ]*",message = "City must start with capital letter and Numbers are not allowed")
	private String city;
	@NotNull(message = "Low value must be given")
	@Min(value = 0,message="Low value cannot be less than 0")
	private Integer low;
	@Max(value=50,message = "High value cannot be greater than 50")
	private Integer high;
	@NotNull(message="Date must be given")
	@JsonFormat(pattern = "yyyy-MM-dd",shape=Shape.STRING)
	@FutureOrPresent(message = "date cannot be less than today")
	@WeatherDateConstraint
	private LocalDate date;
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	@Override
	public String toString() {
		return "Weather [id=" + id + ", city=" + city + ", low=" + low + ", high=" + high + "]";
	}
	
	
}
