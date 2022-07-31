package rest_assured.concepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Serialization {

	public static void main(String[] args) {
		Map<String,Object> jsonBodyUsingMap = new HashMap<String,Object>();
		jsonBodyUsingMap.put("firstname", "Jim");
		jsonBodyUsingMap.put("lastname", "Brown");
		jsonBodyUsingMap.put("totalprice", 111);
		jsonBodyUsingMap.put("depositpaid", true);
		
		Map<String,String> bookingDatesMap = new HashMap<>();
		bookingDatesMap.put("checkin", "2021-07-01");
		bookingDatesMap.put("checkout", "2021-07-01");
		
		jsonBodyUsingMap.put("bookingdates", bookingDatesMap);
		List<String> l=new ArrayList<String>();
		l.add("java");
		l.add("python");
		l.add("R");
		
		jsonBodyUsingMap.put("additionalneeds", l);
		
		RestAssured
		   .given()
			  .baseUri("https://restful-booker.herokuapp.com/booking")
			  .contentType(ContentType.JSON)
			  .body(jsonBodyUsingMap)
			  .log()
			  .all()
		// WHEN
		   .when()
			   .post()
		// THEN
		   .then()
			   .assertThat()
			   .statusCode(200)
			   .log()
			   .all();
	}

}
