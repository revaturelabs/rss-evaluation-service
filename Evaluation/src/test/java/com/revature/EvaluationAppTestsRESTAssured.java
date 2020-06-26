package com.revature;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;
import com.revature.entity.Quiz;
import io.restassured.http.ContentType;


// @SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
class EvaluationAppTestsRESTAssured {
	
	
	// Test GET using REST Assured
	@Test
	public void testSubjecControllerGetAllSubjects() {
		
		get("http://localhost:8080/subject/all")
		.then().assertThat().statusCode(200)
		.body("size",is(1));
	}
	
	// Test POST using REST Assured
	@Test
    public void testQuizControllerFindQuizyId() {
        Quiz quiz = new Quiz();
        quiz.setQuizId(1);
        given()
        	.contentType(ContentType.JSON)
            .body(quiz)
            .post("http://localhost:8080/quiz/findbyid")
            .then().statusCode(200).extract().response();
    }
	
	

}
