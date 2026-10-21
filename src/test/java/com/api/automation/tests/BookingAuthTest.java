package com.api.automation.tests;

import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;

import org.testng.annotations.Test;

import com.api.automation.base.BaseTest;

import io.restassured.response.Response;



public class BookingAuthTest extends BaseTest{
	
	@Test
	public void createTokenTest() {
		
		
		String requestBody = """
				{
					"username": "admin",
					"password": "password123"
				
				}
				""";
		
		Response response = bookingApiClient.createToken(requestBody);
		
	
		
		response.then()
				.spec(responseSpec)
				.body("token", not(emptyOrNullString()));
		
		String token = response.jsonPath().getString("token");
	
		
		System.out.println("Authentication token generated successfully");
	}
}
