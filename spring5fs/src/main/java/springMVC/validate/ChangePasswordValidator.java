package springMVC.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import springMVC.command.ChangePasswordCommand;

public class ChangePasswordValidator implements Validator {
	@Override
	public boolean supports(Class<?> aClass) {
		return ChangePasswordCommand.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currentPassword", "required");
		ValidationUtils.rejectIfEmpty(errors, "newPassword", "required");
	}
}