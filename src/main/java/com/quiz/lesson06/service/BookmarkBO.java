package com.quiz.lesson06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {
	
	@Autowired
	private BookmarkMapper bookmarkMapper;

	// input: X
	// output: List<Bookmark>
	public List<Bookmark> getBookmarkList() {
		return bookmarkMapper.selectBookmarkList();
	}
	
	// input: name, url
	// output: X
	public void addBookmark(String name, String url) {
		bookmarkMapper.insertBookmark(name, url);
	}
	
	// input: url
	// output: boolean(중복 true)
	public boolean isDuplicateUrl(String url) {
		List<Bookmark> bookmarkList = bookmarkMapper.selectBookmarkListByUrl(url);
		// 리스트가 비어있으면 [] 중복 아님 false
		// 리스트가 1개 이상이면 중복임 true
//		if (bookmarkList.isEmpty()) {
//			return false;
//		} 
//		return true;
		return bookmarkList.isEmpty() ? false : true;
	}
	
	public void deleteBookmarkById(int id) {
		bookmarkMapper.deleteBookmarkById(id);
	}
}





