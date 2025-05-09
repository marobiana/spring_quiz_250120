package com.quiz.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {

	// 즐겨찾기 목록 화면
	@GetMapping("/bookmark-list-view")
	public String bookmarkListView() {
		return "lesson06/bookmarkList";
	}
	
	// 즐겨찾기 추가 화면
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
}
