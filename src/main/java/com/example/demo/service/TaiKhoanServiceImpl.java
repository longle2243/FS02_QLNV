package com.example.demo.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.TaiKhoan;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.TaiKhoanRepository;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {
    @Autowired
    private TaiKhoanRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(TaiKhoan taiKhoan) {
        taiKhoan.setPassword(bCryptPasswordEncoder.encode(taiKhoan.getPassword()));
        taiKhoan.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(taiKhoan);
    }

    @Override
    public TaiKhoan findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
