package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.ChiTietCaLam;
import com.example.demo.model.CongViec;
import com.example.demo.service.ChiTietCaLamService;
import com.example.demo.service.CongViecSv;

@Controller
public class ChiTietCaLamcontroller {
	@Autowired
	private ChiTietCaLamService chitietcalamService;
	@Autowired
	private CongViecSv servicecv;
	@GetMapping("/chitietcalam")
	public String viewindex(Model model) {
		model.addAttribute("listchitietcalam",chitietcalamService.getAllChiTietCaLam());
		return "chitietcalam";
	}
	@RequestMapping("/calam")
	public String viewHomePage(Model model) {
	    List<ChiTietCaLam> listCaLam= chitietcalamService.getAllChiTietCaLam();
	    model.addAttribute("listcalam", listCaLam);
	    List<CongViec> listCongViec= servicecv.listAll();
	    model.addAttribute("listcongviec", listCongViec);
	    return "calam";
	}
	@GetMapping("/filterluong")
	public String view() {
		return "filterluong";
	}
	
	@GetMapping("/filterluonguser")
	public String viewluonguser() {
		return "filterluonguser";
	}
	
	@PostMapping("/tkluong")
	public String viewtest(@RequestParam(value="batdau") String batdau ,@RequestParam(value="ketthuc") String ketthuc, Model model) {
		model.addAttribute("listchitiet",chitietcalamService.getAllthongkeluong(batdau,ketthuc));
		return "tkluong";
	}
	
	@PostMapping("/luonguser")
	public String viewtest(@RequestParam(value="batdau") String batdau ,@RequestParam(value="ketthuc") String ketthuc,@RequestParam(value="manv") Integer manv, Model model) {
		model.addAttribute("listchitiet",chitietcalamService.getAllthongkeluongnv(batdau,ketthuc,manv));
		return "luongcanhan";
	}
	
	@RequestMapping(value = "/savechamcong", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("chamcong") ChiTietCaLam ChiTietCaLam) {
		chitietcalamService.savechitiet(ChiTietCaLam);
	    return "redirect:/s";
	}
	
	@RequestMapping("/dangkicalam")
	public String showNewChamCongPage(Model model) {
	    ChiTietCaLam ChiTietCaLam = new ChiTietCaLam();
	    model.addAttribute("chamcong", ChiTietCaLam);	

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
}

















