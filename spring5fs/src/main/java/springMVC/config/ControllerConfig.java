package springMVC.config;

import springMVC.auth.AuthService;
import springMVC.controller.LoginController;
import springMVC.controller.LogoutController;
import springMVC.controller.RegisterController;

import springMVC.controller.SurveyController;
import springMVC.member.MemberRegisterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"springMVC"})
public class ControllerConfig {
	@Autowired
	private MemberRegisterService memberRegisterService;

	@Autowired
	private AuthService authService;

	@Bean
	public RegisterController registerController() {
		RegisterController registerController = new RegisterController();
		registerController.setMemberRegisterService(memberRegisterService);

		return registerController;
	}

	@Bean
	public SurveyController surveyController() {
		return new SurveyController();
	}

	@Bean
	public LoginController loginController() {
		LoginController loginController = new LoginController();
		loginController.setAuthService(authService);

		return loginController;
	}

	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}
}