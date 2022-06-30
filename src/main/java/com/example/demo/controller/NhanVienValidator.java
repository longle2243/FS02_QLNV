package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.demo.model.NhanVien;
import com.example.demo.service.NhanVienSv;

@Component
public class NhanVienValidator implements Validator {
    @Autowired
    private NhanVienSv nhanVienService;

    @Override
    public boolean supports(Class<?> aClass) {
        return NhanVien.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NhanVien nhanVien = (NhanVien) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (nhanVien.getUsername().length() < 6 || nhanVien.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (nhanVienService.findByUsername(nhanVien.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (nhanVien.getPassword().length() < 8 || nhanVien.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!nhanVien.getPasswordConfirm().equals(nhanVien.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}
