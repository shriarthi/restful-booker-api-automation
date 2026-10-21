package com.api.automation.data;


public class BookingTestData {
	
	
	public static String validBooking() {
		
		
		return"""
				
			{

				"firstname": "John",
                "lastname": "Smith",
                "totalprice": 200,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2026-11-15",
                    "checkout": "2026-11-20"
                },
                "additionalneeds": "Breakfast"

	}
		""";		
	

	}

}
