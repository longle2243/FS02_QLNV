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
import com.example.demo.model.ChamCong;
import com.example.demo.model.ChucVu;
import com.example.demo.model.CongViec;
import com.example.demo.model.NhanVien;
import com.example.demo.service.CaLamSv;
import com.example.demo.service.ChamCongSv;
import com.example.demo.service.CongViecSv;

@Controller
public class ChamCongcontroller {
		@Autowired
		private ChamCongSv service;
		@Autowired
		private CaLamSv servicecl;
		@Autowired
		private CongViecSv servicecv;
		
//		@RequestMapping("/congvieccanhan")
//		public String viewHomePage(Model model) {
//		    List<ChamCong> listnhanvien= service.listAll();
//		    model.addAttribute("listchamcong", listnhanvien);
//		    
//		    List<ChamCong> congvieccuatoi= service.listAll();
//		    model.addAttribute("chamcongcuatoi", congvieccuatoi);
//		    return "congvieccanhan";
//		}
//		
//		@RequestMapping("/congvieccanhan")
//		public String showNewnhanvienPage(Model model) {
//		    ChamCong chamcong = new ChamCong();
//		    model.addAttribute("chamcong", chamcong);	
//		    List<ChamCong> congvieccuatoi= service.listAll();
//		    model.addAttribute("chamcongcuatoi", congvieccuatoi);
//		    return "congvieccanhan";
//		}
		
		@RequestMapping("/congvieccanhan/{id}")
		public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		    ModelAndView mav = new ModelAndView("congvieccanhan");
		    ChamCong ChamCong = service.get(id);
		    mav.addObject("chamcong", ChamCong);     
		    return mav;
		}
		
		@RequestMapping("/dangkicalam")
		public String showNewChamCongPage(Model model) {
		    ChamCong ChamCong = new ChamCong();
		    model.addAttribute("chamcong", ChamCong);	
		    
		    List<CaLam> listCaLam= servicecl.listAll();
		    model.addAttribute("listcalam", listCaLam);
		    
		    List<CongViec> listCongViec= servicecv.listAll();
		    model.addAttribute("listcongviec", listCongViec);
		    
		    List<Object[]> listCongViecSang= servicecv.congviecsang();
		    model.addAttribute("listcongviecsang", listCongViecSang);
		    List<Object[]> listCongViecChieu= servicecv.congviecchieu();
		    model.addAttribute("listcongviecchieu", listCongViecChieu);
		    List<Object[]> listCongViecToi= servicecv.congviectoi();
		    model.addAttribute("listcongviectoi", listCongViecToi);
		    return "dangkicalam";
		}
		
		@RequestMapping(value = "/savechamcong", method = RequestMethod.POST)
		public String saveProduct(@ModelAttribute("chamcong") ChamCong ChamCong) {
		    service.save(ChamCong);
		    return "redirect:/canhan/1";
		}
}
