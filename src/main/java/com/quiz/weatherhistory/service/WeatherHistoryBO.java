package com.quiz.weatherhistory.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weatherhistory.domain.WeatherHistory;
import com.quiz.weatherhistory.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBO {
	
	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;

	// input: X
	// output: List<WeatherHistory>
	public List<WeatherHistory> getWeatherHistoryList() {
		return weatherHistoryMapper.selectWeatherHistoryList();
	}
	
	// input: 6개
	// output: X
	public void addWeatherHistory(
			LocalDate date, String weather,
			String microDust, double temperatures,
			double precipitation, double windSpeed) {
		
		weatherHistoryMapper.insertWeatherHistory(date, weather, 
				microDust, temperatures, precipitation, windSpeed);
	}
}




