package com.revature.test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;


@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
class EvaluationApplicationTestsRESTAssured {
	
	// REST Assured Tests
	public void testResponsecode() {
		Response resp = RestAssured.get("http://localhost:8080/subjects/all");
		int code = resp.getStatusCode();
		
		System.out.println("Status code is :" + code);
		
		Assert.assertEquals(code, 200);
	}
	
	public void testResponseBody() {
		Response resp = RestAssured.get("http://localhost:8080/subjects/all");
		
		String data = resp.asString();
		
		System.out.println("Data retrieved is :" + data);
	}	
	
	
	@Test
	public void testSubjecControllerGetAllSubjects() {
		
		get("http://localhost:8080/subject/all")
		.then().assertThat().statusCode(200)
		.body("size",is(0));
	}
	
	

}
