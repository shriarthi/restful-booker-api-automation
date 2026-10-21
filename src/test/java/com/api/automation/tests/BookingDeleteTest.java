package com.api.automation.tests;


import org.testng.annotations.Test;

import com.api.automation.base.BaseTest;
import com.api.automation.data.BookingTestData;

import io.restassured.response.Response;


public class BookingDeleteTest extends BaseTest{

	@Test
    public void deleteBookingTest() {

        Response createResponse =
                bookingApiClient.createBooking(BookingTestData.validBooking());

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

        Response deleteResponse =
                bookingApiClient.deleteBooking(bookingId, token);

        // Restful Booker returns 201 for a successful DELETE
        deleteResponse.then()
                .statusCode(201);

        // Verify the deleted booking cannot be retrieved
        Response getResponse = bookingApiClient.getBooking(bookingId);

        getResponse.then()
                .statusCode(404);

        System.out.println("Booking deleted and verified successfully");
    }
}
	

