package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.invoke.MethodHandles;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@RequestMapping(value = "/")
	public String main(Model model) {
		logger.info("MainController RequestMapping /");

		model.addAttribute("title", "spring9");
		model.addAttribute("message", "hello spring");

		return "index";
	}
}