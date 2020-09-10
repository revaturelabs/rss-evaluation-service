package com.revature;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import com.revature.service.QuizService;
import com.revature.service.SubjectService;
import org.junit.jupiter.api.Test;
import com.revature.entity.Quiz;
import io.restassured.http.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
class EvaluationAppTestsRESTAssured {
	@Autowired
	private SubjectService ss;

	@Autowired
	private QuizService qs;
	// Test GET using REST Assured
	@Test
	public void testSubjecControllerGetAllSubjects() {
		int size = ss.subjectList().size();
		System.out.println(size);
		get("http://localhost:8080/subject/obtain/all")
		.then().assertThat().statusCode(200)
		.body("size",is(size));
	}
	
	// Test POST using REST Assured
	@Test
    public void testQuizControllerFindQuizyId() {
        Quiz quiz = qs.getAllQuizzes().get(0);
        given()
        	.contentType(ContentType.JSON)
            .body(quiz)
            .post("http://localhost:8080/quiz/obtain/id")
            .then().statusCode(200).extract().response()
				.then().assertThat().body( "quizId",is((int)quiz.getQuizId()));

    }
	
	

}
