package springMVC.controller;

import common.exception.WrongIdPasswordException;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springMVC.auth.AuthInfo;
import springMVC.command.ChangePasswordCommand;
import springMVC.member.ChangePasswordService;
import springMVC.validate.ChangePasswordValidator;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePasswordController {
	private ChangePasswordService changePasswordService;

	public void setChangePasswordService(ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}

	@GetMapping
	public String form(@ModelAttribute("command") ChangePasswordCommand changePasswordCommandS) {
		return "edit/changePasswordForm";
	}

	@PostMapping
	public String submit(@ModelAttribute("command") ChangePasswordCommand changePasswordCommand, Errors errors, HttpSession httpSession) {
		new ChangePasswordValidator().validate(changePasswordCommand, errors);
		if (errors.hasErrors()) {
			return "edit/changePasswordForm";
		}

		AuthInfo authInfo = (AuthInfo) httpSession.getAttribute("authInfo");
		try {
			changePasswordService.changePassword(authInfo.getEmail(), changePasswordCommand.getCurrentPassword(), changePasswordCommand.getNewPassword());
			return "edit/changePassword";
		} catch (WrongIdPasswordException e) {
			errors.rejectValue("currentPassword", "notMatching");
			return "edit/changePasswordForm";
		}
	}
}