package com.quiz.weatherhistory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {
	// 날씨 목록 화면
	@GetMapping("/weather-history-view")
	public String weatherHistoryView() {
		return "weatherHistory/weatherList";
	}

	// 날씨 추가 화면
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weatherHistory/addWeather";
	}
}
