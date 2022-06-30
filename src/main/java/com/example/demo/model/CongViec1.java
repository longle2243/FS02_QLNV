package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CongViec1 {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "macongviec")
    private Integer macongviec;
	private String congviec,buoi,diadiem,noidung,nguoigiao;
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
	public String getBuoi() {
		return buoi;
	}
	public void setBuoi(String buoi) {
		this.buoi = buoi;
	}
	public String getDiadiem() {
		return diadiem;
	}
	public void setDiadiem(String diadiem) {
		this.diadiem = diadiem;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	public String getNguoigiao() {
		return nguoigiao;
	}
	public void setNguoigiao(String nguoigiao) {
		this.nguoigiao = nguoigiao;
	}
	@Override
	public String toString() {
		return "CongViec [macongviec=" + macongviec + ", congviec=" + congviec + ", buoi=" + buoi + ", diadiem="
				+ diadiem + ", noidung=" + noidung + ", nguoigiao=" + nguoigiao + "]";
	}
	public CongViec1(Integer macongviec, String congviec, String buoi, String diadiem, String noidung,
			String nguoigiao) {
		this.macongviec = macongviec;
		this.congviec = congviec;
		this.buoi = buoi;
		this.diadiem = diadiem;
		this.noidung = noidung;
		this.nguoigiao = nguoigiao;
	}
	public CongViec1() {
	}
	
	
}
