package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CongViec;
import com.example.demo.repository.CongViecRepo;

	@Service
	@Transactional
	public class CongViecSv {
		@Autowired
		private CongViecRepo repo;
		
		public List<CongViec> listAll(){
			return repo.findAll();
		}
		
		public void save(CongViec ent) {
			repo.save(ent);
		}
		
		public CongViec get(int id) {
			return repo.findById(id).get();
		}
		
		public void delete(int id) {
			repo.deleteById(id);
		}
		 
		public List<Object[]> congviecsang(){
			 return repo.congviecbuoisang();
		}
		public List<Object[]> congviecchieu(){
			 return repo.congviecbuoichieu();
		}
		public List<Object[]> congviectoi(){
			 return repo.congviecbuoitoi();
		}		
}
