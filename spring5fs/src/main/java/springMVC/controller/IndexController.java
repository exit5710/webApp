package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping(value = "/")
	public String main(Model model) {
		model.addAttribute("title", "string5fs");

		return "index";
	}
}