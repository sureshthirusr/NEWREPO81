package rest_assured.concepts;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.path.json.JsonPath;

public class Deserialization {

	public static void main(String[] args) throws Throwable {

		FileReader file = new FileReader(".//payload.txt");

		JSONParser jp = new JSONParser();
		Object obj = jp.parse(file);
		
		JSONObject jo = (JSONObject) obj;
		Object stNameObj = jo.get("studentName");

		System.out.println("StudentName is: " + stNameObj.toString());

		Object phoneObj = jo.get("phone");
		JSONArray json_phone_Array = (JSONArray) phoneObj;

		System.out.println(json_phone_Array.get(0));

		for (int i = 0; i < json_phone_Array.size(); i++) {

			JSONObject explrObject = (JSONObject) json_phone_Array.get(i);
			if (explrObject.get("mobile") != null) {
				System.out.println(explrObject.get("mobile"));
			}
		}
	}
}
