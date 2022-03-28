package com.junitwithmockito.Utility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.junitwithmockito.models.Weather;

public class RequestResponseGenerator {

	public static Weather createWeatherObject() {
		Weather weather = new Weather();
		weather.setId(001);
		weather.setCity("Mumbai");
		weather.setHigh(24);
		weather.setLow(17);
		weather.setDate(LocalDate.parse("2022-01-08"));
		return weather;
	}

	public static List<Weather> createWeatherObjectList(String city) {
		List<Weather> list = new ArrayList<>();
		List<Weather> list1 = new ArrayList<>();
		Map<String, List<Weather>> map = new HashMap<String, List<Weather>>();

		Weather weather = new Weather();
		weather.setId(001);
		weather.setCity("Mumbai");
		weather.setHigh(24);
		weather.setLow(17);
		weather.setDate(LocalDate.parse("2022-01-08"));

		Weather weather1 = new Weather();
		weather1.setId(002);
		weather1.setCity("Mumbai");
		weather1.setHigh(25);
		weather1.setLow(16);
		weather1.setDate(LocalDate.parse("2022-01-09"));

		Weather weather2 = new Weather();
		weather2.setId(003);
		weather2.setCity("NaviMumbai");
		weather2.setHigh(24);
		weather2.setLow(17);
		weather2.setDate(LocalDate.parse("2022-01-08"));

		list.add(weather);
		list.add(weather1);
		map.put("Mumbai", list);

		list1.add(weather2);
		map.put("NaviMumbai", list1);
		return map.get(city);
	}

	public static List<Weather> createWeatherResponseList() {
		List<Weather> list = new ArrayList<>();

		Weather weather = new Weather();
		weather.setId(001);
		weather.setCity("Mumbai");
		weather.setHigh(24);
		weather.setLow(17);
		weather.setDate(LocalDate.parse("2022-02-13")); 

		Weather weather1 = new Weather();
		weather1.setId(002);
		weather1.setCity("Mumbai");
		weather1.setHigh(25);
		weather1.setLow(16);
		weather1.setDate(LocalDate.parse("2022-02-13"));

		Weather weather2 = new Weather();
		weather2.setId(003);
		weather2.setCity("NaviMumbai");
		weather2.setHigh(24);
		weather2.setLow(17);
		weather2.setDate(LocalDate.parse("2022-02-13"));

		list.add(weather);
		list.add(weather1);
		list.add(weather2);
		return list;
	}

}
