package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ChiTietCaLam;

@Repository
public interface ChiTietCaLamRepository extends JpaRepository <ChiTietCaLam, Integer>{
	@Query(value="SELECT c.nv.hoten, c.nv.chucvu.chucvu,COUNT(c.cl.buoi),c.nv.chucvu.heso, SUM(c.cl.luongcalam) * c.nv.chucvu.heso FROM ChiTietCaLam AS c WHERE c.ngaydangky BETWEEN convert(?1,DATE) AND convert(?2,DATE) GROUP BY c.nv.manhanvien")
	List<Object[]> tkluong(String batdau, String ketthuc);

	@Query(value = "SELECT c.nv.hoten, c.nv.chucvu.chucvu, COUNT(c.cl.buoi),c.nv.chucvu.heso, SUM(c.cl.luongcalam) * c.nv.chucvu.heso "
			+ "FROM ChiTietCaLam AS c WHERE c.ngaydangky BETWEEN convert(?1,DATE) AND convert(?2,DATE) AND c.nv.manhanvien=?3")
	List<Object[]> luongnv(String batdau, String ketthuc,Integer manv);
}
