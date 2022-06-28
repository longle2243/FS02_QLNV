package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ChucVu {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "machucvu")
	    private Integer machucvu;
		private String chucvu,heso;
		public Integer getMachucvu() {
			return machucvu;
		}
		public void setMachucvu(Integer machucvu) {
			this.machucvu = machucvu;
		}
		public String getChucvu() {
			return chucvu;
		}
		public void setChucvu(String chucvu) {
			this.chucvu = chucvu;
		}
		public String getHeso() {
			return heso;
		}
		public void setHeso(String heso) {
			this.heso = heso;
		}
		@Override
		public String toString() {
			return "ChucVu [machucvu=" + machucvu + ", chucvu=" + chucvu + ", heso=" + heso + "]";
		}
		
		
}
