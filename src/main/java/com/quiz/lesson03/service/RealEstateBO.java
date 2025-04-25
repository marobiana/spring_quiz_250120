package com.quiz.lesson03.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {
	
	@Autowired
	private RealEstateMapper realEstateMapper;

	// input: id
	// output: RealEstate(단건) or null
	public RealEstate getRealEstateById(int id) {
		return realEstateMapper.selectRealEstateById(id);
	}
	
	public List<RealEstate> getRealEstateListByRentPrice(int rentPrice) {
		return realEstateMapper.selectRealEstateListByRentPrice(rentPrice);
	}
	
	public List<RealEstate> getRealEstateListByAreaPrice(int area, int price) {
		return realEstateMapper.selectRealEstateListByAreaPrice(area, price);
	}
	
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	
//	addRealEstateAsField(
//			realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세",
//			100000, 120);
	public int addRealEstateAsField(int realtorId2,
			String address2, int area2, String type2,
			int price2, Integer rentPrice2) {
		
		return realEstateMapper.insertRealEstateAsField(realtorId2, address2, area2, type2, price2, rentPrice2);
	}
}






