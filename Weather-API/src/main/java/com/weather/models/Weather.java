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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
//	@NotNull(message="Date must be given")
	//@JsonFormat(pattern = "yyyy-MM-dd",shape=Shape.STRING)
	//@FutureOrPresent(message = "date cannot be less than today")
	//@WeatherDateConstraint
	private LocalDate date;
	

}
