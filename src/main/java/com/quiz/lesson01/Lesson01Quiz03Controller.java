package com.quiz.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson01Quiz03Controller {

	// http://localhost:8080/lesson01/quiz03/1
	@RequestMapping("/lesson01/quiz03/1")
	public String quiz03() {
		// @ResponseBody가 아닌 상태로 string을 리턴하면
		// ViewResolver에 의해 리턴된 html 경로를 찾아 화면이 구성됨
		
		// /templates/   lesson01/quiz03    .html
		return "lesson01/quiz03";
	}
}




