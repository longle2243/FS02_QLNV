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
	private String congviec,buoi,diadiem,noidung,nguoigiao;
	private long luongcalam;
	
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
	public long getLuongcalam() {
		return luongcalam;
	}
	public void setLuongcalam(long luongcalam) {
		this.luongcalam = luongcalam;
	}
	@Override
	public String toString() {
		return "CongViec [macongviec=" + macongviec + ", congviec=" + congviec + ", buoi=" + buoi + ", diadiem="
				+ diadiem + ", noidung=" + noidung + ", nguoigiao=" + nguoigiao + ", luongcalam=" + luongcalam + "]";
	}
	
	
}
