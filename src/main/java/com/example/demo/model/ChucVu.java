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
		private String chucvu;
		private float heso;
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
		public float getHeso() {
			return heso;
		}
		public void setHeso(float heso) {
			this.heso = heso;
		}
		@Override
		public String toString() {
			return "ChucVu [machucvu=" + machucvu + ", chucvu=" + chucvu + ", heso=" + heso + "]";
		}
		
		
		
}
