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
	import com.example.demo.service.ChucVuSv;
	
	@Controller
		public class ChucVucontroller {
		@Autowired
		private ChucVuSv service;
		
		@RequestMapping("/chucvu")
		public String viewHomePage(Model model) {
		    List<ChucVu> listChucVu= service.listAll();
		    model.addAttribute("listchucvu", listChucVu);
		    return "chucvu";
		}
		
		@RequestMapping("/themchucvu")
		public String showNewChucVuPage(Model model) {
		    ChucVu ChucVu = new ChucVu();
		    model.addAttribute("chucvu", ChucVu);	     
		    return "themchucvu";
		}
		
		@RequestMapping(value = "/savechucvu", method = RequestMethod.POST)
		public String saveProduct(@ModelAttribute("ChucVu") ChucVu ChucVu) {
		    service.save(ChucVu);
		    return "redirect:/chucvu";
		}
		
		@RequestMapping("/editchucvu/{id}")
		public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		    ModelAndView mav = new ModelAndView("editchucvu");
		    ChucVu ChucVu = service.get(id);
		    mav.addObject("chucvu", ChucVu);     
		    return mav;
		}
		
		@RequestMapping("/deletechucvu/{id}")
		public String deleteProduct(@PathVariable(name = "id") int id) {
		    service.delete(id);
		    return "redirect:/chucvu";       
		}
	}

