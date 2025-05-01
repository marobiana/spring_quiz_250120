package com.quiz.lesson04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {
	
	@Autowired
	private SellerMapper sellerMapper;

	// input: 3개 파라미터
	// output: X
	public void addSeller(String nickname, 
			String profileImageUrl, double temperature) {
		
		sellerMapper.insertSeller(nickname, profileImageUrl, temperature);
	}
	
	// input: X
	// output: Seller(단건 or null)
	public Seller getLatestSeller() {
		return sellerMapper.selectLatestSeller();
	}
	
	// input: id
	// output: Seller(단건 or null)
	public Seller getSellerById(int id) {
		return sellerMapper.selectSellerById(id);
	}
}





