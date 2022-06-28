package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CaLam;
import com.example.demo.repository.CaLamRepo;

@Service
@Transactional
public class CaLamSv {
	@Autowired
	private CaLamRepo repo;
	
	public List<CaLam> listAll(){
		return repo.findAll();
	}
	
	public void save(CaLam ent) {
		repo.save(ent);
	}
	
	public CaLam get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
}
