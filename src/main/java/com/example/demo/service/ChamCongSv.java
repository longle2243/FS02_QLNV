package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ChamCong;
import com.example.demo.repository.ChamCongRepo;

@Service
@Transactional
public class ChamCongSv {

		@Autowired
		private ChamCongRepo repo;
		
		public List<ChamCong> listAll(){
			return repo.findAll();
		}
		
		public void save(ChamCong ent) {
			repo.save(ent);
		}
		
		public ChamCong get(int id) {
			return repo.findById(id).get();
		}
		
		public void delete(int id) {
			repo.deleteById(id);
		}
		
		public List<Object[]> congvieccanhan(Integer manv){
			 return repo.congvieccuatoi(manv);
		}	
}
