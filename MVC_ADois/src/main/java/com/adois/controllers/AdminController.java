package com.adois.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adois.models.Admin;
import com.adois.repositoryes.AdminRepository;
import com.adois.util.accesLevel;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	private accesLevel accesLevel;
	
	
	@GetMapping
	public ModelAndView listAdmin() {
		ModelAndView mav = new ModelAndView("admin/listAdmin.html");
		List<Admin> admins = adminRepository.findByAccesLevel(accesLevel);
		mav.addObject("admins", admins);
		return mav;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarAdmin() {
		ModelAndView mav = new ModelAndView("admin/cad.html");
		mav.addObject("admin", new Admin());
		return mav;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrarAdmin(Admin admin) {
		ModelAndView mav = new ModelAndView("redirect:/admin");
		adminRepository.save(admin);
		return mav;
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("redirect:/admin");
		adminRepository.deleteById(id);
		return mav;
	}
	
	@GetMapping("/{id}/detalhes")
	public ModelAndView detalhes(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("admin/details");
		Admin admin = adminRepository.getReferenceById(id);
		mav.addObject("admin", admin);
		return mav;
	}
	
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("admin/edit");
		mav.addObject("admin", adminRepository.getReferenceById(id));
		return mav;
	}
	
	@PostMapping("/{id}/editar")
	public ModelAndView editar(Admin admin) {
		ModelAndView mav = new ModelAndView("redirect:/admin");
		adminRepository.save(admin);
		return mav;
	}	
	
}
