package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	// AJAX 요청 - 즐겨찾기 추가
	@ResponseBody
	@PostMapping("/add-bookmark")
	public Map<String, Object> addBookmark(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// db insert
		bookmarkBO.addBookmark(name, url);
		
		// 성공 여부
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200); // 성공
		result.put("result", "성공");
		
		return result;
	}
	
	// AJAX 요청 - URL 중복확인
	@ResponseBody
	@PostMapping("/is-duplicate-url")
	public Map<String, Object> isDuplicateUrl(
			@RequestParam("url") String url) {
		
		// db select
		boolean isDuplicate = bookmarkBO.isDuplicateUrl(url);
		
		// 응답값 JSON string
		Map<String, Object> result = new HashMap<>();
		// {"code":200, "is_duplicate":true} => 중복
		result.put("code", 200);
		result.put("is_duplicate", isDuplicate);
		return result;
	}
}






