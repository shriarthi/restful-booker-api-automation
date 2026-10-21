package com.api.automation.tests;


import org.testng.annotations.Test;

import com.api.automation.base.BaseTest;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

public class BookingNegativeTest extends BaseTest {

	
	@Test
    public void invalidAuthenticationTest() {

        String authBody = """
            {
                "username": "invalidUser",
                "password": "invalidPassword"
            }
            """;

        Response response =
                bookingApiClient.createToken(authBody);

        response.then()
                .spec(responseSpec)
                .body("reason", equalTo("Bad credentials"));

        System.out.println("Invalid authentication test passed");
    }
	
	@Test
	public void getNonExistingBookingTest() {
		
		Response response = bookingApiClient.getBooking(999999999);
		
		response.then()
			.statusCode(404)
			.body(equalTo("Not Found"));
		
		System.out.println("Non-existing booking test passed");
	}

}
