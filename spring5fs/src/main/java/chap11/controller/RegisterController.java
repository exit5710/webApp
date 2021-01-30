package chap11.controller;

import chap11.member.MemberRegisterService;
import chap11.member.RegisterRequest;

import common.exception.DuplicateMemberException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String handleStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree) {
		if (!agree) {
			return "register/step1";
		}

		return "register/step2";
	}

	@RequestMapping("/register/step3")
	public String handleStep3(RegisterRequest registerRequest) {
		try {
			memberRegisterService.regist(registerRequest);
			return "register/step3";
		} catch (DuplicateMemberException e) {
			return "register/step2";
		}
	}
}