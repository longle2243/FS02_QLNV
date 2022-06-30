package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.ChiTietCaLamService;

@Controller
public class ChiTietCaLamcontroller {
	@Autowired
	private ChiTietCaLamService chitietcalamService;
	
	@GetMapping("/chitietcalam")
	public String viewindex(Model model) {
		model.addAttribute("listchitietcalam",chitietcalamService.getAllChiTietCaLam());
		return "chitietcalam";
	}
	
	@GetMapping("/filterluong")
	public String view() {
		return "filterluong";
	}
	
	@PostMapping("/tkluong")
	public String viewtest(@RequestParam(value="batdau") String batdau ,@RequestParam(value="ketthuc") String ketthuc, Model model) {
		model.addAttribute("listchitiet",chitietcalamService.getAllthongkeluong(batdau,ketthuc));
		return "tkluong";
	}
	
	@PostMapping("/luongnhanvien")
	public String viewtest(@RequestParam(value="batdau") String batdau ,@RequestParam(value="ketthuc") String ketthuc,@RequestParam(value="manv") Integer manv, Model model) {
		model.addAttribute("listchitiet",chitietcalamService.getAllthongkeluongnv(batdau,ketthuc,manv));
		return "luongnhanvien";
	}
}

















