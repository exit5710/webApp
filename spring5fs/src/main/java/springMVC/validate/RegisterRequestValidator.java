package springMVC.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import springMVC.member.RegisterRequest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterRequestValidator implements Validator {
	private static final String emailRexExp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;

	public RegisterRequestValidator() {
		this.pattern = Pattern.compile(emailRexExp);
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return RegisterRequest.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object object, Errors errors) {
		RegisterRequest registerRequest = (RegisterRequest) object;

		if (registerRequest.getEmail() == null || registerRequest.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
		} else {
			Matcher matcher = pattern.matcher(registerRequest.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "bad");
			}
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
		if (!registerRequest.getPassword().isEmpty()) {
			if (!registerRequest.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("confirmPassword", "noMatch");
			}
		}
	}
}