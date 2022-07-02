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
	
	@Query(value = "SELECT * FROM nhan_vien AS c WHERE c.username = ?1",nativeQuery = true) // sao lai la username mà khong phai la hoten spring security co ham getName lay username dang chay t lay do de so sanh dung thi cho vao trnag thong tin ca nhan
//	List<NhanVien> infocanhan( );
	List<NhanVien> infocanhan(String username);
}
// lỗi unknow đó là do m để cái nativeQuery = true, vì cái đó là quy định m phải sài sql kiểu truyền thống ko có chữ c ở sau chữ SELECT, thay vào đó phải là dấu * 
