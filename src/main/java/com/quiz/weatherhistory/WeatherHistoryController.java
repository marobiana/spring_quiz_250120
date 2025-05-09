package com.quiz.weatherhistory;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// 추가 기능 => 날씨 목록 화면
	@PostMapping("/add-weather")
	public String addWeather(
			//@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			@RequestParam("date") LocalDate date,
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed) {
		
		// db insert
		weatherHistoryBO.addWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
		
		// 목록 화면 => 302 redirect
		//response.sendRedirect("/weather-history/weather-history-view");
		return "redirect:/weather-history/weather-history-view";
	}
}








