package com.example.demo.controller;

import org.springframework.validation.Validator;

import com.example.demo.model.TaiKhoan;
import com.example.demo.service.TaiKhoanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;


@Component
public class TaiKhoanValidator implements Validator {
	@Autowired
	private TaiKhoanService taiKhoanService;

	@Override
	public boolean supports(Class<?> aClass) {
		return TaiKhoan.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		TaiKhoan tk = (TaiKhoan) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (tk.getUsername().length() < 6 || tk.getUsername().length() > 32) {
			errors.rejectValue("username", "Size.userForm.username");
		}
		if (taiKhoanService.findByUsername(tk.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (tk.getPassword().length() < 8 || tk.getPassword().length() > 32) {
			errors.rejectValue("password", "Size.userForm.password");
		}

		if (!tk.getPasswordConfirm().equals(tk.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
		}
	}

	
}

