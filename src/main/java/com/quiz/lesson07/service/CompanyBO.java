package com.quiz.lesson07.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {
	
	@Autowired
	private CompanyRepository companyRepository;

	// input: 4개 파라미터
	// output: CompanyEntity
	public CompanyEntity addCompany(String name, 
			String business, String scale, int headcount) {
		
		return companyRepository.save(CompanyEntity.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build());
	}
	
	public CompanyEntity updateCompanyById(
			int id, String scale, int headcount) {
		
		// 기존 데이터 가져옴
		CompanyEntity company = companyRepository.findById(id).orElse(null);
		
		// 기존 데이터 있을 때만 업데이트
		if (company != null) {
			// save(update) 후 다시 가져온 데이터를 꼭 저장
			company = companyRepository.save(company.toBuilder()
					.scale(scale)
					.headcount(headcount)
					.build());
		}
		
		return company;
	}
	
	// input: id
	// output: X
	public void deleteCompanyById(int id) {
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
		companyOptional.ifPresent(c -> companyRepository.delete(c));
	}
}



