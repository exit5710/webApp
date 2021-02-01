package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springMVC.survey.AnsweredData;
import springMVC.survey.Question;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	@GetMapping
	public String form(Model model) {
		List<Question> questions = createQuestions();
		model.addAttribute("questions", questions);

		return "survey/surveyForm";
	}

	private List<Question> createQuestions() {
		Question q1 = new Question("당신의 역할은?", Arrays.asList("서버", "프로트", "풀스택"));
		Question q2 = new Question("가장많이 사용하는 개발도구는?", Arrays.asList("이클립스", "인텔리J", "서브라임"));
		Question q3 = new Question("하고싶은 말");

		return Arrays.asList(q1, q2, q3);
	}

	@PostMapping
	public String submit(@ModelAttribute("ansData") AnsweredData data) {
		//model.addAttribute("ansData", data);
		return "survey/submitted";
	}
}