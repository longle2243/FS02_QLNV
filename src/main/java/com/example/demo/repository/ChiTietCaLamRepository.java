package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ChiTietCaLam;


@Repository
public interface ChiTietCaLamRepository extends JpaRepository <ChiTietCaLam, Integer>{


	
//	@Query(value = "SELECT c.nv.hoten, c.nv.cvu.chucvu, COUNT(c.cl.macalam),c.nv.cvu.heso, SUM(c.cl.luongcalam) * c.nv.cvu.hesoluong FROM ChiTietCaLam AS c GROUP BY c.nv.manhanvien")

//	@Query(value = "SELECT c.nv.hoten, c.nv.chucvu.chucvu, COUNT(c.cl.buoi),c.nv.chucvu.heso, SUM(c.cl.luongcalam) * c.nv.chucvu.heso "
//			+ "FROM ChiTietCaLam AS c WHERE c.ngaydangky BETWEEN convert(?1,DATE) AND convert(?2,DATE) " 
//			+ "GROUP BY c.nv.manhanvien")
	@Query(value="SELECT c.nv.hoten, c.nv.chucvu.chucvu,COUNT(c.cl.buoi),c.nv.chucvu.heso, SUM(c.cl.luongcalam) * c.nv.chucvu.heso FROM ChiTietCaLam AS c WHERE c.ngaydangky BETWEEN convert(?1,DATE) AND convert(?2,DATE) GROUP BY c.nv.manhanvien")
	List<Object[]> tkluong(String batdau, String ketthuc);

//	List<Object[]> tkluong();
	
//	@Query(value = "SELECT c.nv.tennv, c.nv.cvu.tenchucvu, COUNT(c.cl.macalam),c.nv.cvu.hesoluong, SUM(c.cl.luongcalam) * c.nv.cvu.hesoluong "
//			+ "FROM ChiTietCaLam AS c WHERE c.ngaydangky BETWEEN convert(?1,DATE) AND convert(?2,DATE) AND c.nv.manhanvien=1")
//	List<Object[]> tkluong(String batdau, String ketthuc);
}
