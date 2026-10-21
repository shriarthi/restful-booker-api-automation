package com.api.automation.tests;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.api.automation.base.BaseTest;
import com.api.automation.data.BookingTestData;

import io.restassured.response.Response;



public class BookingCreateTest extends BaseTest {
	
	
	
	@Test
	public void PostBookingTest() {
		
		
	String requestBody = BookingTestData.validBooking();

	Response response = bookingApiClient.createBooking(requestBody);
	
	
	int bookingId = 	
		
	given()
		.spec(requestSpec)
		.body(requestBody)
	.when()
		.post("/booking")
	.then()
		.spec(responseSpec)
		.body("booking.firstname", equalTo("John"))
		.body("booking.lastname", equalTo("Smith"))
		.body("booking.totalprice", equalTo(200))
		.body("booking.depositpaid", equalTo(true))
		.extract()
		.path("bookingid");
		
	System.out.println("Create Booking ID:" + bookingId);
	
	
	//Calls the getBooking() method inside BookingAPIClient,passes the dynamically generated booking id to that method
	//stores the HTTP response in the getResponse variable.
	
	Response getResponse = bookingApiClient.getBooking(bookingId);
	
	getResponse.then()
		.spec(responseSpec)
		.body("firstname", equalTo("John"))
		.body("lastname", equalTo("Smith"))
		.log().body();
	
	}
	
}	
		

