package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
	@RequestMapping("/logout")
	public String logOut(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/main";
	}
}