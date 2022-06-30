package com.example.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ctcl")
public class ChiTietCaLam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idchitiet;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date ngaydangky;

	@ManyToOne
	@JoinColumn(name = "macongviec")
	private CongViec cl;

	@ManyToOne
	@JoinColumn(name = "manhanvien")
	private NhanVien nv;

	public Integer getIdchitiet() {
		return idchitiet;
	}

	public void setIdchitiet(Integer idchitiet) {
		this.idchitiet = idchitiet;
	}

	public Date getNgaydangky() {
		return ngaydangky;
	}

	public void setNgaydangky(Date ngaydangky) {
		this.ngaydangky = ngaydangky;
	}

	public CongViec getCl() {
		return cl;
	}

	public void setCl(CongViec cl) {
		this.cl = cl;
	}

	public NhanVien getNv() {
		return nv;
	}

	public void setNv(NhanVien nv) {
		this.nv = nv;
	}

	@Override
	public String toString() {
		return "ChiTietCaLam [idchitiet=" + idchitiet + ", ngaydangky=" + ngaydangky + ", cl=" + cl + ", nv=" + nv
				+ "]";
	}

	public ChiTietCaLam() {
	}

	public ChiTietCaLam(Integer idchitiet, Date ngaydangky, com.example.demo.model.CongViec cl,
			com.example.demo.model.NhanVien nv) {
		this.idchitiet = idchitiet;
		this.ngaydangky = ngaydangky;
		this.cl = cl;
		this.nv = nv;
	}
	
	
}

