package com.example.demo.service;

import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.repository.NhanVienRepo;
import com.example.demo.repository.RoleRepository;
import com.example.demo.model.NhanVien;

@Service
@Transactional
public class NhanVienSv {

	@Autowired
	private NhanVienRepo repo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private RoleRepository roleRepository;

	public List<NhanVien> listAll() {
		return repo.findAll();
	}

	public void save(NhanVien nhanvien) {
		nhanvien.setPassword(bCryptPasswordEncoder.encode(nhanvien.getPassword()));
		nhanvien.setRoles(new HashSet<>(roleRepository.findAll()));
		repo.save(nhanvien);
	}

	public NhanVien get(int id) {
		return repo.findById(id).get();
	}

	public void delete(int id) {
		repo.deleteById(id);
	}

	public NhanVien findByUsername(String username) {
		return repo.findByUsername(username);
	}

	public List<NhanVien> getthongtincanhan(String username) {
		return repo.thongtincannhan(username);
	}
	
//	public List<NhanVien> getinfouser( ) {
//		return repo.infocanhan();
//	}
	public List<NhanVien> getinfouser(String username) {
		return repo.infocanhan(username);
	}
}







