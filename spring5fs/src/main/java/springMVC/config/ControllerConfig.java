package springMVC.config;

import springMVC.controller.RegisterController;

import springMVC.member.MemberRegisterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"springMVC"})
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