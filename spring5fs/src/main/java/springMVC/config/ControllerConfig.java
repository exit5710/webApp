package springMVC.config;

import springMVC.auth.AuthService;
import springMVC.controller.*;

import springMVC.member.ChangePasswordService;
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

	@Autowired
	private ChangePasswordService changePasswordService;

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

	@Bean
	public ChangePasswordController changePasswordController() {
		ChangePasswordController changePasswordController = new ChangePasswordController();
		changePasswordController.setChangePasswordService(changePasswordService);

		return changePasswordController;
	}
}