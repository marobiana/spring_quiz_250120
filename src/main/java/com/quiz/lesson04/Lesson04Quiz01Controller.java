package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.service.SellerBO;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	
	@Autowired
	private SellerBO sellerBO;

	// 추가 화면
	// http://localhost:8080/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	// 추가 기능
	// /lesson04/quiz01/add-seller
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam("temperature") double temperature) {
		
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return "lesson04/afterAddSeller";
	}
	
	// 최근 가입자 한명 정보 화면
	// /lesson04/quiz01/seller-info-view
	// /lesson04/quiz01/seller-info-view?id=3
	@GetMapping("/seller-info-view")
	public String sellerInfoView(
			@RequestParam(value = "id", required = false) Integer id,
			Model model) {
		// db select
		Seller seller = null;
		if (id == null) { // 최신가입자
			seller = sellerBO.getLatestSeller();
		} else { // id에 해당하는 사용자
			seller = sellerBO.getSellerById(id);
		}
		
		// model에 담기
		model.addAttribute("seller", seller);
		model.addAttribute("title", "판매자 정보");
		
		// 화면
		return "lesson04/sellerInfo";
	}
	
}
