package com.sv.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sv.app.bean.UserBean;
import com.sv.app.service.UserService;

public class RequestValidator implements Validator {
	@Autowired
	UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserBean.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		 /* User user = (User) o;

	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
	        if (user.getUserName().length() < 6 || user.getUserName().length() > 32) {
	            errors.rejectValue("username", "Size.userForm.username");
	        }
	       if (userService.findByUsername(user.getUsername()) != null) {
	            errors.rejectValue("username", "Duplicate.userForm.username");
	        }

	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
	        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
	            errors.rejectValue("password", "Size.userForm.password");
	        }

	        if (!user.getPasswordConfirm().equals(user.getPassword())) {
	            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
	        }*/
	    }
	
	/*
	 * public boolean userLoginValidate(String email, String password) { boolean
	 * userValidate; String authToken = UUID.randomUUID().toString(); userValidate =
	 * userService.setAuthToken(authToken, email, password); return userValidate; }
	 */
		
	}
