package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.ChamCong;
import com.example.demo.model.NhanVien;

public interface ChamCongRepo extends JpaRepository <ChamCong, Integer>{
	@Query(value = "SELECT a.macongviec,a.buoi,a.congviec,a.diadiem,a.nguoigiao,a.noidung  FROM ChamCong AS a CongViec a, NhanVien b, ChamCong c WHERE a.macongviec=c.macongviec AND b.manhanvien=c.manhanvien AND b.manhanvien = ?1",nativeQuery = true)
	List<Object[]> congvieccuatoi(Integer manv);
}
