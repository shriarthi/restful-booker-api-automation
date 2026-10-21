package com.api.automation.tests;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.api.automation.base.BaseTest;
import com.api.automation.data.BookingTestData;

import io.restassured.response.Response;


public class BookingPatchTest extends BaseTest{
	 @Test
	    public void partialUpdateBookingTest() {

	        String requestBody = BookingTestData.validBooking();

	        Response createResponse =
	                bookingApiClient.createBooking(requestBody);

	        int bookingId = createResponse.then()
	                .spec(responseSpec)
	                .extract()
	                .path("bookingid");

	        String authBody = """
	            {
	                "username": "admin",
	                "password": "password123"
	            }
	            """;

	        Response authResponse = bookingApiClient.createToken(authBody);

	        String token = authResponse.then()
	                .spec(responseSpec)
	                .extract()
	                .path("token");

	        String patchBody = """
	            {
	                "firstname": "David",
	                "totalprice": 450
	            }
	            """;

	        Response patchResponse =
	                bookingApiClient.partialUpdateBooking(bookingId, token, patchBody);

	        patchResponse.then()
	                .spec(responseSpec)
	                .body("firstname", equalTo("David"))
	                .body("lastname", equalTo("Smith"))
	                .body("totalprice", equalTo(450));

	        Response getResponse = bookingApiClient.getBooking(bookingId);

	        getResponse.then()
	                .spec(responseSpec)
	                .body("firstname", equalTo("David"))
	                .body("lastname", equalTo("Smith"))
	                .body("totalprice", equalTo(450));

	        System.out.println("Booking partially updated and verified successfully");
	    }
	}
