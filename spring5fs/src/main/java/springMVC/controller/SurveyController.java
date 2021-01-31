package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springMVC.survey.AnsweredData;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	@GetMapping
	public String form() {
		return "survey/surveyForm";
	}

	@PostMapping
	public String submit(@ModelAttribute("ansData") AnsweredData data) {
		//model.addAttribute("ansData", data);
		return "survey/submitted";
	}
}