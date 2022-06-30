package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ChiTietCaLam;


@Repository
public interface ChiTietCaLamRepository extends JpaRepository <ChiTietCaLam, Integer>{
//	@Query(value = "SELECT c.nv.hoten, c.nv.cvu.chucvu, COUNT(c.cl.macalam),c.nv.cvu.heso, SUM(c.cl.luongcalam) * c.nv.cvu.hesoluong FROM ChiTietCaLam AS c GROUP BY c.nv.manhanvien")
//	List<Object[]> tkluong();
}
