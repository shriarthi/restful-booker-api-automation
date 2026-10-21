package com.api.automation.client;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class BookingApiClient {

	private final RequestSpecification requestSpec;
	
	//this is an constructor it runs when we create an object
	
	public BookingApiClient(RequestSpecification requestSpec) {
		
		this.requestSpec = requestSpec;
	}
	
	
    public Response createBooking(String requestBody) {
    	
    	return given()
    			.spec(requestSpec)
    			.body(requestBody)
    	
    			.when()
    				.post("/booking");
    	
    }
	
    public Response getBooking(int bookingId) {
    	
    	
    	return given()
    			.spec(requestSpec)
    			.pathParam("id", bookingId)
    		.when()
    			.get("/booking/{id}");
    	
    }
	
    public Response getAllBookings() {
    	
    	return given()
    			.spec(requestSpec)
    		.when()
    			.get("/booking");
    	
    }
    
    
   public Response createToken(String requestBody) {
	 
	   return given()
			   .spec(requestSpec)
			   .body(requestBody)
			 .when()
			 	.post("/auth");   
	   
   }
    
   public Response updateBooking(int bookingId, String token, String requestBody) {
	   
	 return given()
			 .spec(requestSpec)
			 .header("cookie", "token=" + token)
			 .pathParam("id", bookingId)
			 .body(requestBody)
		.when()
			.put("/booking/{id}");
	   
   }
   
   public Response partialUpdateBooking(int bookingId, String token, String requestBody) {
	    return given()
	            .spec(requestSpec)
	            .header("Cookie", "token=" + token)
	            .pathParam("id", bookingId)
	            .body(requestBody)
	        .when()
	            .patch("/booking/{id}");
	}

	public Response deleteBooking(int bookingId, String token) {
	    return given()
	            .spec(requestSpec)
	            .header("Cookie", "token=" + token)
	            .pathParam("id", bookingId)
	        .when()
	            .delete("/booking/{id}");
	}
    
    
}



