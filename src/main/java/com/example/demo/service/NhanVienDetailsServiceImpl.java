package com.example.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.NhanVien;
import com.example.demo.model.Role;
import com.example.demo.repository.NhanVienRepo;

@Service
public class NhanVienDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private NhanVienRepo nhanVienRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        NhanVien nhanVien = nhanVienRepository.findByUsername(username);
        if (nhanVien == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : nhanVien.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(nhanVien.getUsername(), nhanVien.getPassword(), grantedAuthorities);
    }
}
