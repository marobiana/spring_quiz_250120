package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {

	// input: id
	// output: RealEstate(단건) or null
	public RealEstate selectRealEstateById(int id);
	
	// input: rentPrice(int)
	// output: List<RealEstate>
	public List<RealEstate> selectRealEstateListByRentPrice(int rentPrice);
	
	// input: area, price
	// output: List<RealEstate>
	public List<RealEstate> selectRealEstateListByAreaPrice(
			// xml로 파라미터를 보낼 때 한개밖에 못보낸다.
			// 파라미터들을 하나의 Map으로 담아 보낸다.
			// @Param 어노테이션을 붙이면 하나의 Map이 된다.
			@Param("area1") int area11111, 
			@Param("price1") int price222222);
	
	// input: RealEstate
	// output: int(성공한 행 개수)
	public int insertRealEstate(RealEstate realEstate);
	
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId1,
			@Param("address") String address1, 
			@Param("area") int area1, 
			@Param("type") String type1,
			@Param("price") int price1, 
			@Param("rentPrice") Integer rentPrice1);
}





