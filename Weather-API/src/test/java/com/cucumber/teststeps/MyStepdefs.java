package com.cucumber.teststeps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;


public class MyStepdefs {



   @Given("Adding the weather details")
    public void addingTheWeatherDetails() {
    }

    @And("I perform POST operation")
    public void iPerformPOSTOperation() {

        String jsonBody = "{" + "\"city\": \"Brisbane\"," + "\"low\": 8," + "\"high\": 32," + "\"date\": \"2022-03-29\""
                + "}";

        given().body(jsonBody).contentType("application/json")
                .when()
                .post("http://localhost:8080/api/weather/addWeatherDetails")
                .then()
                .statusCode(200);


    }
    @Then("I Should see the details of the city")
    public void iShouldSeeTheDetailsOfTheCity() {
    }

    @Given("Update the Weather details by id")
    public void updateTheWeatherDetailsById() {

    }

    @And("I Perform UPDATE operation")
    public void iPerformUPDATEOperation() {

        String jsonBody = "{" + "\"city\": \"Brisbane\"," + "\"low\": 11," + "\"high\": 48," + "\"date\": \"2022-03-29\""
                + "}";
        given().body(jsonBody).contentType("application/json")
                .when()
                .put("http://localhost:8080/api/weather/31")
                .then()
                .statusCode(200);

    }
    @Then("I Should see the details of the updated city")
    public void iShouldSeeTheDetailsOfTheUpdatedCity() {
    }

    @Given("Fetch Weather details by City")
    public void fetchWeatherDetailsByCity() {
    }

    @And("I perform GET operation")
    public void iPerformGETOperation() {
        Response response = given()
                .when()
                .get("http://localhost:8080/api/weather/fetchWeatherDetailsByCity?city=India")
                .andReturn();
        System.out.println(response.asString());
    }



    @Given("delete the Weather details by City")
    public void deleteTheWeatherDetailsByCity() {

    }

    @And("I Perform DELETE operation")
    public void iPerformDELETEOperation() {
        Response response = given()
                .when()
                .delete("http://localhost:8080/api/weather/deleteByCity?city=Tasmania")
                .andReturn();
        System.out.println(response.asString());
    }

    @Given("A List of cities")
    public void aListOfCities() {
    }
    @And("I perform All GET operation")
    public void iPerformAllGETOperation() {
        RestAssured.given()
                .then()
                .expect()
                .statusCode(200)
                .when()
                .get("http://localhost:8080/api/weather/fetchAllCities");
    }



}

