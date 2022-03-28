package com.junitwithmockito.models;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WeatherDateValidator implements ConstraintValidator<WeatherDateConstraint, LocalDate> {

	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		LocalDate maxdate=LocalDate.now().plusDays(7);
		System.out.println(maxdate+ " => "+value);
		return maxdate.isAfter(value);
	}

}
