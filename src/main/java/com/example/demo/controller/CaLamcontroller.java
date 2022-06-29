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

import com.example.demo.model.CaLam;
import com.example.demo.model.CongViec;
import com.example.demo.service.CaLamSv;
import com.example.demo.service.CongViecSv;



@Controller
public class CaLamcontroller {
	@Autowired
	private CaLamSv service;
	@Autowired
	private CongViecSv service1;
	
	@RequestMapping("/calam")
	public String viewHomePage(Model model) {
	    List<CaLam> listCaLam= service.listAll();
	    model.addAttribute("listcalam", listCaLam);
	    return "calam";
	}
	
	@RequestMapping("/themcalam")
	public String showNewCaLamPage(Model model) {
	    CaLam CaLam = new CaLam();
	    model.addAttribute("calam", CaLam);	
	    List<CongViec> listCongViec= service1.listAll();
	    model.addAttribute("listcongviec", listCongViec);
	    return "themcalam";
	}
	
	@RequestMapping(value = "/savecalam", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("calam") CaLam CaLam) {
	    service.save(CaLam);
	    return "redirect:/calam";
	}
	
	@RequestMapping("/editcalam/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("editcalam");
	    CaLam CaLam = service.get(id);
	    mav.addObject("calam", CaLam);     
	    return mav;
	}
	
	@RequestMapping("/deletecalam/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
	    service.delete(id);
	    return "redirect:/calam";       
	}
}

	
	
	
	
	
	
	
	
	
	
	