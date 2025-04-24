package com.quiz.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {

	// input: id
	// output: RealEstate(단건) or null
	public RealEstate selectRealEstateById(int id);
}





