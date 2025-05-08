package com.quiz.weatherhistory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.weatherhistory.domain.WeatherHistory;
import com.quiz.weatherhistory.service.WeatherHistoryBO;

@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	// 날씨 목록 화면
	@GetMapping("/weather-history-view")
	public String weatherHistoryView(Model model) {
		// select db
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistoryList();
		
		// model
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		
		return "weatherHistory/weatherList";
	}

	// 날씨 추가 화면
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weatherHistory/addWeather";
	}
}
