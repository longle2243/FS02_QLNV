package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class NhanVien {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manhanvien")
    private Integer manhanvien;
	private String hoten,sdt,email;
	public Integer getManhanvien() {
		return manhanvien;
	}
	public void setManhanvien(Integer manhanvien) {
		this.manhanvien = manhanvien;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "NhanVien [manhanvien=" + manhanvien + ", hoten=" + hoten + ", sdt=" + sdt + ", email=" + email + "]";
	}
	
//	public NhanVien(Integer manhanvien, String hoten, String sdt, String email) {
//		this.manhanvien = manhanvien;
//		this.hoten = hoten;
//		this.sdt = sdt;
//		this.email = email;
//	}
//	public NhanVien() {
//	}
	
	
}
