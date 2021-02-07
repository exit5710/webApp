package springMVC.auth;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import springMVC.login.LoginCommand;

public class LoginCommandValidator implements Validator {
	@Override
	public boolean supports(Class<?> aClass) {
		return LoginCommand.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
	}
}