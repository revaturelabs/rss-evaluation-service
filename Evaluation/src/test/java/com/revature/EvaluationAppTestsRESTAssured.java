package com.revature;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import com.revature.entity.Subject;
import com.revature.service.QuizService;
import com.revature.service.SubjectService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.revature.entity.Quiz;
import io.restassured.http.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class EvaluationAppTestsRESTAssured {
	private static boolean initialized = false;
	private static int numTests = 0;
	@LocalServerPort
	private int port;
	@Autowired
	private SubjectService ss;

	@Autowired
	private QuizService qs;


	@BeforeEach
	void setUp() {
		if (!initialized) {
			Subject test = new Subject();
			test.setSubjectName("test subject");
			ss.insertSubject(test);
			Quiz tes = new Quiz();
			tes.setQuizTopic("test topic");
			tes.setQuizDescription("test works");
			tes.setCreatorEmail("test");
			Subject str = findSubject("test subject");
			System.out.println(str);
			tes.setSubject(str);
			tes.setSubjectId(str.getSubjectId());
			qs.insertQuiz(tes);
			initialized = true;
		}
	}

	private Subject findSubject(String subName) {
		List<Subject> subs = ss.subjectList();
		System.out.println(subs);
		for (Subject sub: subs) {
			if (sub.getSubjectName().equals(subName))
				return sub;
		}
		return null;
	}

	@AfterEach
	void tearDown() {
		numTests++;
		if (numTests == 4) {
			qs.getAllQuizzes().forEach(quiz -> {
				if(quiz.getSubject().getSubjectName().equals("test subject"))
					qs.deleteQuizById(quiz.getQuizId());
			});
			List<Subject> subs = ss.subjectList();
			subs.forEach(subject -> {
				if (subject.getSubjectName().equals("test subject") || subject.getSubjectName().equals("new subject"))
					ss.deleteSubjectById(subject.getSubjectId());
			});
			System.out.println("cleared everything see results below");
			System.out.println(ss.subjectList());
			System.out.println(qs.getAllQuizzes());
		}
	}

	@Test
	void testSubjectControllerInsertSubject() {
		Subject sub = new Subject();
		sub.setSubjectName("new subject");
		ss.subjectList().forEach(subject -> {
			if(subject.getSubjectName().equals("new subject"))
				ss.deleteSubjectById(subject.getSubjectId());
		});
		given()
				.contentType(ContentType.JSON)
				.body(sub)
				.post("http://localhost:" + port + "/subject/admin/add")
				.then().assertThat().body(is("{'message':'Subject added successfully.'}"));
		System.out.println(ss.subjectList());
	}

	// Test GET using REST Assured
	@Test
	public void testSubjecControllerGetAllSubjects() {
		int size = ss.subjectList().size();
		System.out.println(size);
		get("http://localhost:" + port + "/subject/obtain/all")
		.then().assertThat().statusCode(200)
		.body("size",is(size));
		System.out.println(ss.subjectList());
	}
	
	// Test POST using REST Assured
	@Test
    public void testQuizControllerFindQuizyId() {
        Quiz quiz = qs.getAllQuizzes().get(0);
        given()
        	.contentType(ContentType.JSON)
            .body(quiz)
            .post("http://localhost:"+ port + "/quiz/obtain/id")
            .then().statusCode(200).extract().response()
				.then().assertThat().body( "quizId",is((int)quiz.getQuizId()));

    }

	@Test
	void testQuizControllerGetAllQuizzes() {
		given()
				.get("http://localhost:" + port + "/quiz/obtain/all")
				.then().statusCode(200).extract().response();
	}
}
