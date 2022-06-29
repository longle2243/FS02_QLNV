package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class ChamCong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "manhanvien")
	private NhanVien nhanvien;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "macalam")
	private CaLam calam;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "macongviec")
	private CongViec congviec;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public NhanVien getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}

	public CaLam getCalam() {
		return calam;
	}

	public void setCalam(CaLam calam) {
		this.calam = calam;
	}

	public CongViec getCongviec() {
		return congviec;
	}

	public void setCongviec(CongViec congviec) {
		this.congviec = congviec;
	}

	@Override
	public String toString() {
		return "ChamCong [id=" + id + ", nhanvien=" + nhanvien + ", calam=" + calam + ", congviec=" + congviec + "]";
	}

	

}
