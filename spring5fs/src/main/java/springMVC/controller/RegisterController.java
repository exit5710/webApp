package springMVC.controller;

import org.springframework.validation.Errors;
import springMVC.member.MemberRegisterService;
import springMVC.member.RegisterRequest;

import common.exception.DuplicateMemberException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springMVC.validate.RegisterRequestValidator;

@Controller
public class RegisterController {
	private MemberRegisterService memberRegisterService;

	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}

	@RequestMapping("/register/step1")
	public String handleStep1() {
		return "register/step1";
	}

	@RequestMapping("/register/step2")
	public String handleStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree, RegisterRequest registerRequest) {
		if (!agree) {
			return "register/step1";
		}

		return "register/step2";
	}

	@RequestMapping("/register/step3")
	public String handleStep3(RegisterRequest registerRequest, Errors errors) {
		try {
			if (registerRequest.getEmail() == null || registerRequest.getName() == null || registerRequest.getPassword() == null) {
				return "register/step1";
			}

			new RegisterRequestValidator().validate(registerRequest, errors);
			if (errors.hasErrors()) {
				return "register/step2";
			}

			memberRegisterService.regist(registerRequest);
			return "register/step3";
		} catch (DuplicateMemberException e) {
			errors.rejectValue("email", "duplicate");
			return "register/step2";
		}
	}
}