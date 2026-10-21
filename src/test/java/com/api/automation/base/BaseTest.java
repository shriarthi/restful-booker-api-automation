package com.api.automation.base;



import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import com.api.automation.client.BookingApiClient;



public class BaseTest {
	
	
	protected RequestSpecification requestSpec;
	protected ResponseSpecification responseSpec;
	protected BookingApiClient bookingApiClient;
	
	public BaseTest() {
		
		requestSpec = new RequestSpecBuilder()
				.setBaseUri("https://restful-booker.herokuapp.com")
				.setContentType("application/json")
				.setAccept("application/json")
				.build();
		
		
		responseSpec = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType("application/json")
				.build();
		
		
	bookingApiClient = new BookingApiClient(requestSpec);	
		
	}
	

}
