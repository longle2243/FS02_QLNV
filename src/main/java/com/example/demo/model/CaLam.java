package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CaLam {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "macalam")
	    private Integer macalam;
		private String buoi,thoigian,diadiem;
		public Integer getMacalam() {
			return macalam;
		}
		public void setMacalam(Integer macalam) {
			this.macalam = macalam;
		}
		public String getBuoi() {
			return buoi;
		}
		public void setBuoi(String buoi) {
			this.buoi = buoi;
		}
		public String getThoigian() {
			return thoigian;
		}
		public void setThoigian(String thoigian) {
			this.thoigian = thoigian;
		}
		public String getDiadiem() {
			return diadiem;
		}
		public void setDiadiem(String diadiem) {
			this.diadiem = diadiem;
		}
		@Override
		public String toString() {
			return "CaLam [macalam=" + macalam + ", buoi=" + buoi + ", thoigian=" + thoigian + ", diadiem=" + diadiem
					+ "]";
		}
		
		
}
