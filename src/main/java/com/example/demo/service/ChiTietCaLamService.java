package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ChiTietCaLam;

public interface ChiTietCaLamService {
	List<ChiTietCaLam> getAllChiTietCaLam();
	List<Object[]> getAllthongkeluong(String batdau, String ketthuc);
	List<Object[]> getAllthongkeluongnv(String batdau, String ketthuc,Integer manv);
	
	void savechitiet(ChiTietCaLam ctcl) ;
}
