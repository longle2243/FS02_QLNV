package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.NhanVienRepo;
import com.example.demo.model.NhanVien;

@Service
@Transactional
public class NhanVienSv {
	
	@Autowired
	private NhanVienRepo repo;
	
	public List<NhanVien> listAll(){
		return repo.findAll();
	}
	
	public void save(NhanVien ent) {
		repo.save(ent);
	}
	
	public NhanVien get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
}














