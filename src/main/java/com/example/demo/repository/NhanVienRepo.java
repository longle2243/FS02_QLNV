package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.NhanVien;

public interface NhanVienRepo extends JpaRepository<NhanVien, Integer>{
	@Query("SELECT u FROM NhanVien u WHERE u.hoten = :hoten")
	NhanVien findUserById(@Param("hoten") String name);
}
