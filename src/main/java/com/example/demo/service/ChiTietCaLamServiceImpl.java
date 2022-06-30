package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ChiTietCaLam;
import com.example.demo.repository.ChiTietCaLamRepository;

@Service
public class ChiTietCaLamServiceImpl implements ChiTietCaLamService {
	@Autowired
	private ChiTietCaLamRepository chitietcalamRepository;
	
	@Override
	public List<ChiTietCaLam> getAllChiTietCaLam(){
		return chitietcalamRepository.findAll();
	}
	@Override
	public List<Object[]> getAllthongkeluong(String batdau, String ketthuc) {
		return chitietcalamRepository.tkluong(batdau,ketthuc);
	}
	@Override
	public List<Object[]> getAllthongkeluongnv(String batdau, String ketthuc,Integer manv) {
		return chitietcalamRepository.luongnv(batdau,ketthuc,manv);
	}
//	@Override
//	public List<Object[]> getAllthongkeluong() {
//		return chitietcalamRepository.tkluong();
//	}
}
