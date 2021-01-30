package chap11.config;

import chap11.controller.RegisterController;

import chap11.member.MemberRegisterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"chap11"})
public class ControllerConfig {
	@Autowired
	private MemberRegisterService memberRegisterService;

	@Bean
	public RegisterController registerController() {
		RegisterController registerController = new RegisterController();
		registerController.setMemberRegisterService(memberRegisterService);

		return registerController;
	}
}