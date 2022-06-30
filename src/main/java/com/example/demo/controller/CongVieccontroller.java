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

	import com.example.demo.model.CongViec;
import com.example.demo.model.NhanVien;
import com.example.demo.service.CongViecSv;
import com.example.demo.service.NhanVienSv;

	@Controller
	public class CongVieccontroller {
		@Autowired
		private CongViecSv service;
		@Autowired
		private NhanVienSv service1;
		
		@RequestMapping("/congviec")
		public String viewHomePage(Model model) {
		    List<CongViec> listCongViec= service.listAll();
		    model.addAttribute("listCongViec", listCongViec);
		    return "congviec";
		}
		
		@RequestMapping("/themCongViec")
		public String showNewCongViecPage(Model model) {
		    CongViec CongViec = new CongViec();
		    model.addAttribute("CongViec", CongViec);
		    List<NhanVien> listnhanvien= service1.listAll();
		    model.addAttribute("listnhanvien", listnhanvien);
		    return "themCongViec";
		}
		
		@RequestMapping(value = "/saveCongViec", method = RequestMethod.POST)
		public String saveProduct(@ModelAttribute("CongViec") CongViec CongViec) {
		    service.save(CongViec);
		    return "redirect:/congviec";
		}
		
		@RequestMapping("/editCongViec/{id}")
		public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		    ModelAndView mav = new ModelAndView("editCongViec");
		    CongViec CongViec = service.get(id);
		    mav.addObject("CongViec", CongViec);     
		    return mav;
		}
		
		@RequestMapping("/deleteCongViec/{id}")
		public String deleteProduct(@PathVariable(name = "id") int id) {
		    service.delete(id);
		    return "redirect:/congviec";       
		}
		
		@RequestMapping("/congvieccanhan")
		public String viewcongviecuser(Model model) {
		    List<CongViec> listCongViec= service.listAll();
		    model.addAttribute("listCongViec", listCongViec);
		  
		    return "congvieccanhan";
		}
		
	}
