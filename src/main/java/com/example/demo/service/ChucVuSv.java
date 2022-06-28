package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ChucVu;
import com.example.demo.repository.ChucVuRepo;

	@Service
	@Transactional
	public class ChucVuSv {
		@Autowired
		private ChucVuRepo repo;
		
		public List<ChucVu> listAll(){
			return repo.findAll();
		}
		
		public void save(ChucVu ent) {
			repo.save(ent);
		}
		
		public ChucVu get(int id) {
			return repo.findById(id).get();
		}
		
		public void delete(int id) {
			repo.deleteById(id);
		}
}
