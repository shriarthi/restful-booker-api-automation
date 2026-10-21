package com.api.automation.tests;



import org.testng.annotations.Test;
import com.api.automation.base.BaseTest;
import io.restassured.response.Response;
import com.api.automation.data.BookingTestData;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;



public class BookingGetTest extends BaseTest{
	
	
	@Test
	public void getBookingTest() {
	
		
		//Get reusable JSON test data
		String requestBody = BookingTestData.validBooking();
		
		//Create a new booking
		
		Response createResponse = bookingApiClient.createBooking(requestBody);
		
		//Extract the newly generated booking ID
		
		int bookingId = createResponse.then()
				.spec(responseSpec)
				.extract()
				.path("bookingid");
		
		//Retrieve the booking we just created
		Response getResponse = bookingApiClient.getBooking(bookingId);
		
		//validate the GET response
		
		getResponse.then()
				.spec(responseSpec)
				.body("firstname", equalTo("John"))
				.body("lastname", equalTo("Smith"))
				.body("totalprice", equalTo(200))
				.log().body();
				
	}
	
	@Test
	public void getBookingIdTest() {
	//Get all bookingIDs
	Response listResponse = bookingApiClient.getAllBookings();		
		
	// Validate the booking list	
	listResponse.then()
			.spec(responseSpec)
			.body("size()", greaterThan(0))
			.body("bookingid[0]", greaterThan(0));
	
	//extract the first booking
	int bookingId = listResponse.then()
			.spec(responseSpec)
			.extract()
			.path("[0].bookingid");
		
	System.out.println("First Booking Id: " + bookingId);
	
	
	// Get details of that booking
	
	  Response bookingResponse = bookingApiClient.getBooking(bookingId);
	  
	  //Validate and print the booking details
	   bookingResponse.then()
	    	.spec(responseSpec)
	    	.log().body();
	

	
	}

}
