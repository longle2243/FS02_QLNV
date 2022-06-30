package com.example.demo.model;

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
public class CaLam {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "macalam")
	    private Integer macalam;
		private String nguoithuchien;
		@ManyToOne
		@JoinColumn(name="macongviec")
		private CongViec congviec;
		public Integer getMacalam() {
			return macalam;
		}
		public void setMacalam(Integer macalam) {
			this.macalam = macalam;
		}
		public String getNguoithuchien() {
			return nguoithuchien;
		}
		public void setNguoithuchien(String nguoithuchien) {
			this.nguoithuchien = nguoithuchien;
		}
		public CongViec getCongviec() {
			return congviec;
		}
		public void setCongviec(CongViec congviec) {
			this.congviec = congviec;
		}
		@Override
		public String toString() {
			return "CaLam [macalam=" + macalam + ", nguoithuchien=" + nguoithuchien + ", congviec=" + congviec + "]";
		}
		
		
}
