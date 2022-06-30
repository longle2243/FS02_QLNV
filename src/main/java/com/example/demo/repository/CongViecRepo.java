package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.CongViec;
import com.example.demo.model.NhanVien;

public interface CongViecRepo extends JpaRepository<CongViec, Integer>{
	
	@Query("SELECT a.macongviec,a.buoi,a.congviec,a.diadiem,a.nguoigiao,a.noidung FROM CongViec a WHERE a.buoi='Sáng'")
	List<Object[]> congviecbuoisang();
	
	@Query("SELECT a.macongviec,a.buoi,a.congviec,a.diadiem,a.nguoigiao,a.noidung FROM CongViec a WHERE a.buoi='Chiều'")
	List<Object[]> congviecbuoichieu();
	
	@Query("SELECT a.macongviec,a.buoi,a.congviec,a.diadiem,a.nguoigiao,a.noidung FROM CongViec a WHERE a.buoi='Tối'")
	List<Object[]> congviecbuoitoi();
	
	@Query(value ="SELECT c.macongviec,c.buoi,c.congviec,c.diadiem,c.nguoigiao,c.noidung FROM CongViec AS a, NhanVien AS b, ChamCong AS c WHERE a.macongviec=c.macongviec AND b.manhanvien=c.manhanvien AND b.manhanvien = ?1",nativeQuery = true)
	CongViec congvieccanhan(Integer manv);
}
