package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.ChucVu;
import com.example.demo.model.NhanVien;
import com.example.demo.service.ChucVuSv;
import com.example.demo.service.NhanVienSv;

@Controller
public class NhanViencontroller {
	@Autowired
	private NhanVienSv service;
	@Autowired
	private ChucVuSv service1;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
	    List<NhanVien> listnhanvien= service.listAll();
	    model.addAttribute("listnhanvien", listnhanvien);
	    List<ChucVu> listChucVu= service1.listAll();
	    model.addAttribute("listchucvu", listChucVu);
	    return "index";
	}
	
	@RequestMapping("/themnhanvien")
	public String showNewnhanvienPage(Model model) {
	    NhanVien nhanvien = new NhanVien();
	    model.addAttribute("nhanvien", nhanvien);	
	    List<ChucVu> listChucVu= service1.listAll();
	    model.addAttribute("listchucvu", listChucVu);
	    return "themnhanvien";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("nhanvien") NhanVien nhanvien) {
	    service.save(nhanvien);
	    return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id,Model model) {
	    ModelAndView mav = new ModelAndView("editnhanvien");
	    NhanVien nhanvien = service.get(id);
	    mav.addObject("nhanvien", nhanvien);  
	    List<ChucVu> listChucVu= service1.listAll();
	    model.addAttribute("listchucvu", listChucVu);
	    return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
	    service.delete(id);
	    return "redirect:/";       
	}
	@RequestMapping("/tkluong")
	public String getdangki() {
	return "tkluong";
	}
	
	@RequestMapping("/canhan/{id}")
	public ModelAndView showuser(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("canhan");
	    NhanVien nhanvien = service.get(id);
	    mav.addObject("nhanvien", nhanvien);  
	    return mav;
	}
	
	@RequestMapping("/luongcanhan")
	public String getluongcanhan() {
	return "luongcanhan";
	}
	
	
	@RequestMapping(value = "/laythongtinuser", method = RequestMethod.POST)
	public ModelAndView showpageuser(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("laythongtinuser");
	    NhanVien nhanvien = service.get(id);
	    mav.addObject("nhanviencanhan", nhanvien);  
	    return mav;
	}
}




