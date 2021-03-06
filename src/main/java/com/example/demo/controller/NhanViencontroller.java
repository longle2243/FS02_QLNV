package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.ChucVu;
import com.example.demo.model.NhanVien;
import com.example.demo.service.ChucVuSv;
import com.example.demo.service.NhanVienSv;
import com.example.demo.service.SecurityService;

@Controller
public class NhanViencontroller {
	@Autowired
	private NhanVienSv service;
	@Autowired
	private ChucVuSv service1;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private NhanVienValidator userValidator;

	@RequestMapping("/index")
	public String viewHomePage(Model model) {
		List<NhanVien> listnhanvien = service.listAll();
		model.addAttribute("listnhanvien", listnhanvien);
		
		List<ChucVu> listChucVu = service1.listAll();
		model.addAttribute("listchucvu", listChucVu);
		return "index";
	}

	@RequestMapping("/themnhanvien")
	public String showNewnhanvienPage(Model model) {
		NhanVien nhanvien = new NhanVien();
		model.addAttribute("nhanvien", nhanvien);
		List<ChucVu> listChucVu = service1.listAll();
		model.addAttribute("listchucvu", listChucVu);
		return "themnhanvien";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("nhanvien") NhanVien nhanvien) {
		service.save(nhanvien);
		return "redirect:/index";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id, Model model) {
		ModelAndView mav = new ModelAndView("editnhanvien");
		NhanVien nhanvien = service.get(id);
		mav.addObject("nhanvien", nhanvien);
		List<ChucVu> listChucVu = service1.listAll();
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

//	@RequestMapping("/canhan/{id}")
//	public ModelAndView showuser(@PathVariable(name = "id") int id) {
//		ModelAndView mav = new ModelAndView("canhan");
//		NhanVien nhanvien = service.get(id);
//		mav.addObject("nhanvien", nhanvien);
//		return mav;
//	}

	@RequestMapping("/canhan1")
	public String viewuser(Authentication auth, Model model) { // gi??? ?????i url ????? test c??i n??y. GET Th??i
		System.out.println("******************************");
		model.addAttribute("listnhanvien", service.getinfouser(auth.getName()));
		return "canhan";
	}
	//???a n?? kh??ng ra lu??n qua . t test n?? c??n ra ???????c ch??? quanglong1
//	@GetMapping("/testauth")
//	public String index(Authentication auth) {
//		return "auth.getName()";
//	}
	
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

	// LOGN IN USER
	@GetMapping("/registration")
	public String registration(Model model) {
		if (securityService.isAuthenticated()) {
			return "redirect:/";
		}
		model.addAttribute("userForm", new NhanVien());
		return "registration";
	}
	
	@PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") NhanVien userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        service.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/canhan1";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (securityService.isAuthenticated()) {
            return "redirect:/canhan1";
        }
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "login";
    }
    
    // ?????i giao di???n sau ????ng nh???p Admin User index - canhan
    @GetMapping({"/", "/canhan"})
    public String welcome(Model model) {
//    	return "canhan";
    	return "redirect:/canhan1"; 
    }
    
//    public String welcome(Authentication auth) {
////    	SecurityContextHolder.getContext().getAuthentication().getName();
//        return auth.getName();
//
//    }
}
