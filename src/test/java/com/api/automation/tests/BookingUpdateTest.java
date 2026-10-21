package com.api.automation.tests;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.api.automation.base.BaseTest;
import com.api.automation.data.BookingTestData;

import io.restassured.response.Response;



public class BookingUpdateTest extends BaseTest {
	
	@Test
	public void updateBookingTest()
	{
		// 1. Create a booking
        String requestBody = BookingTestData.validBooking();

        Response createResponse =
                bookingApiClient.createBooking(requestBody);

        int bookingId = createResponse.then()
                .spec(responseSpec)
                .extract()
                .path("bookingid");

        // 2. Generate authentication token
        String authBody = """
            {
                "username": "admin",
                "password": "password123"
            }
            """;

        Response authResponse =
                bookingApiClient.createToken(authBody);

        String token = authResponse.then()
                .spec(responseSpec)
                .extract()
                .path("token");

        // 3. Prepare updated booking data
        String updateBody = """
            {
                "firstname": "Michael",
                "lastname": "Johnson",
                "totalprice": 350,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2026-12-01",
                    "checkout": "2026-12-05"
                },
                "additionalneeds": "Lunch"
            }
            """;

        // 4. Update the booking
        Response updateResponse =
                bookingApiClient.updateBooking(bookingId, token, updateBody);

        updateResponse.then()
                .spec(responseSpec)
                .body("firstname", equalTo("Michael"))
                .body("lastname", equalTo("Johnson"))
                .body("totalprice", equalTo(350))
                .body("additionalneeds", equalTo("Lunch"));

        // 5. Verify the update using GET
        Response getResponse =
                bookingApiClient.getBooking(bookingId);

        getResponse.then()
                .spec(responseSpec)
                .body("firstname", equalTo("Michael"))
                .body("lastname", equalTo("Johnson"))
                .body("totalprice", equalTo(350));

        System.out.println("Booking updated and verified successfully");
    }
}
		
		
		
		
		
	
	
	
	


