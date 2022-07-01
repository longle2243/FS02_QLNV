package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.NhanVien;

public interface NhanVienRepo extends JpaRepository<NhanVien, Integer>{
	@Query("SELECT u FROM NhanVien u WHERE u.hoten = :hoten")
	NhanVien findUserById(@Param("hoten") String name);
	NhanVien findByUsername(String username);
	
	@Query("SELECT u FROM NhanVien u WHERE u.username = :username")
	List<NhanVien> thongtincannhan(@Param("username") String username);
	
	@Query(value = "SELECT c FROM NhanVien AS c WHERE c.username= ?1",nativeQuery = true)
//	List<NhanVien> infocanhan( );
	List<NhanVien> infocanhan(String username);
}
