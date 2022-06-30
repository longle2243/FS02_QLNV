package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ctcl")
public class ChiTietCaLam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idchitiet;
	private String ngaydangky;

	@ManyToOne
	@JoinColumn(name = "macalam")
	private CaLam cl;

	@ManyToOne
	@JoinColumn(name = "manhanvien")
	private NhanVien nv;

	@Override
	public String toString() {
		return "ChiTietCaLam [idchitiet=" + idchitiet + ", ngaydangky=" + ngaydangky + ", cl=" + cl + ", nv=" + nv
				+ "]";
	}

	public Integer getIdchitiet() {
		return idchitiet;
	}

	public void setIdchitiet(Integer idchitiet) {
		this.idchitiet = idchitiet;
	}

	public String getNgaydangky() {
		return ngaydangky;
	}

	public void setNgaydangky(String ngaydangky) {
		this.ngaydangky = ngaydangky;
	}

	public CaLam getCl() {
		return cl;
	}

	public void setCl(CaLam cl) {
		this.cl = cl;
	}

	public NhanVien getNv() {
		return nv;
	}

	public void setNv(NhanVien nv) {
		this.nv = nv;
	}

	public ChiTietCaLam() {
		super();
	}

	public ChiTietCaLam(Integer idchitiet, String ngaydangky, CaLam cl, NhanVien nv) {
		super();
		this.idchitiet = idchitiet;
		this.ngaydangky = ngaydangky;
		this.cl = cl;
		this.nv = nv;
	}
}

