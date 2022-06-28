package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CongViec {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "macongviec")
    private Integer macongviec;
	private String congviec,noidung,nguoigiaoviec,nguoithuchien;
	public Integer getMacongviec() {
		return macongviec;
	}
	public void setMacongviec(Integer macongviec) {
		this.macongviec = macongviec;
	}
	public String getCongviec() {
		return congviec;
	}
	public void setCongviec(String congviec) {
		this.congviec = congviec;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	public String getNguoigiaoviec() {
		return nguoigiaoviec;
	}
	public void setNguoigiaoviec(String nguoigiaoviec) {
		this.nguoigiaoviec = nguoigiaoviec;
	}
	public String getNguoithuchien() {
		return nguoithuchien;
	}
	public void setNguoithuchien(String nguoithuchien) {
		this.nguoithuchien = nguoithuchien;
	}
	@Override
	public String toString() {
		return "CongViec [macongviec=" + macongviec + ", congviec=" + congviec + ", noidung=" + noidung
				+ ", nguoigiaoviec=" + nguoigiaoviec + ", nguoithuchien=" + nguoithuchien + "]";
	}
	
	
	
}
