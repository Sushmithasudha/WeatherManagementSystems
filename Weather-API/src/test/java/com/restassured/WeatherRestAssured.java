package com.restassured;

//import java.time.LocalDate;

import io.restassured.response.Response;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import io.restassured.response.Response;
//import net.minidev.json.JSONObject;

import static io.restassured.RestAssured.*;

public class WeatherRestAssured {
    Logger logger = LoggerFactory.logger(WeatherRestAssured.class);

    @BeforeTest
    public void init() {
        baseURI = "http://localhost:8080/api/weather/";
    }

    @Test
    public void testbase() {
        logger.info(baseURI);
    }

    @Test
    public void addWeatherDetails() {

        String jsonBody = "{" + "\"city\": \"Brisbane\"," + "\"low\": 8," + "\"high\": 32," + "\"date\": \"2022-03-29\""
                + "}";

        given().body(jsonBody).contentType("application/json").when().post("/addWeatherDetails").then().statusCode(200);
    }

    @Test
    public void addWeatherDetailsBadRequest() {

        String jsonBody = "{" + "\"city\": \"Brisbane\"," + "\"low\": -1," + "\"high\": 55," + "\"date\": \"2022-03-22\""
                + "}";

        given().body(jsonBody).contentType("application/json").when().post("/addWeatherDetails").then().statusCode(400);
    }

    @Test
    public void updateWeather() {

        String jsonBody = "{" + "\"city\": \"Brisbane\"," + "\"low\": 11," + "\"high\": 48," + "\"date\": \"2022-03-29\""
                + "}";

       given().body(jsonBody).contentType("application/json").when().put("/31").then().statusCode(200);

    }

    @Test
    public void getAllByCity() {
		//when().get("/fetchWeatherDetailsByCity?city=India").then().statusCode(200);
       Response response = given().when().get("/fetchWeatherDetailsByCity?city=India").andReturn();
       System.out.println(response.asString());
    }

    @Test
    public void fetchAllCities() {
		when().get("/fetchAllCities").then().statusCode(200);
      //  Response response = given().when().get("/fetchAllCities").andReturn();
      //  System.out.println(response.asString());
    }

    @Test
    public void deleteByCity() {


       // when().delete("/deleteByCity?city=Tasmaniarty").then().statusCode(200);
           Response response = given().when().delete("/deleteByCity?city=Tasmania").andReturn();
       System.out.println(response.asString());
    }



}


























/*package com.restassured;

import com.weather.controllers.WeatherControllerTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasToString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherRestAssured {
    Logger logger = LoggerFactory.logger(WeatherRestAssured.class);
    private String baseURI;

    @BeforeTest
    public void init() {
        baseURI = "localhost:8080/api/weather/fetchAllCities";
    }

    @Test
    public void testbase()
    {
        logger.info(baseURI);
    }
  /*  @Test
    public void addWeatherDetails() {

        JSONObject requestWeather = new JSONObject();
      //  requestWeather.put("Id", 1);
        requestWeather.put("City", "Mumbai");
        requestWeather.put("High", "40");
        requestWeather.put("Low", "11");
       requestWeather.put("Date", "2022-03-19");
    // requestWeather.put("Date", "LocalDate.parse(/"2022-03-18")");
     //   requestWeather.put("Date", "LocalDate.parse(\"2022-03-18\")");

        logger.info(requestWeather);

      given().
                    body(requestWeather.toJSONString()).contentType("application/json").
                    when().
                  //  post(baseURI + "/addWeatherDetails").
                          post("http://localhost:8080/api/weather/addWeatherDetails").
                    then().statusCode(200);


    }


    @Test
    public void fetchAllCities() {
        when().
                get("http://localhost:8080/api/weather/fetchAllCities").
                then().
                statusCode(200);


    }

}
 */
