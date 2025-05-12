package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.service.BookmarkBO;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	
	@Autowired
	private BookmarkBO bookmarkBO;

	// 1-2) 즐겨찾기 목록 화면
	@GetMapping("/bookmark-list-view")
	public String bookmarkListView(Model model) {
		// DB select
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();
		
		// model
		model.addAttribute("bookmarkList", bookmarkList);
		
		return "lesson06/bookmarkList";
	}
	
	// 1-1) 즐겨찾기 추가 화면
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	// /add-bookmark
}






