package com.adois.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.adois.models.Destiny;
import com.adois.repositoryes.DestinyRepository;
import com.adois.repositoryes.PackageRepository;
import com.adois.models.Package;

@Controller
@RequestMapping("/package")
public class PackageController {
	
	@Autowired
	private PackageRepository packageRepository;
	
	@Autowired
	private DestinyRepository destinyRepository;
	
	
	@GetMapping("{id}/listar")
	public ModelAndView listarPackage(@PathVariable("id") Long id) {
		Destiny destiny = destinyRepository.getReferenceById(id);
		ModelAndView mav = new ModelAndView("package/listPackage.html");
		List<Package> packages = packageRepository.findAllByIdDestiny(id);
		mav.addObject("packages", packages);
		mav.addObject("destiny", destiny);
		return mav;				
	}
	
	@GetMapping("{id}/cadastrar")
	public ModelAndView cadastrar(@PathVariable("id") Long id) {
		Package newPackage= new Package();
		List<Destiny> destinys = destinyRepository.findAll();
		ModelAndView mav = new ModelAndView("package/cad.html");
		mav.addObject("newPackage", newPackage);
		mav.addObject("destinys", destinys);
		return mav;
	}
	
	@PostMapping("{id}/cadastrar")
	public ModelAndView cadastrar(@PathVariable("id") Long id,
								  @ModelAttribute Package newPackage,
								  @RequestParam("idDest") Long idDest) {
		
		Destiny destiny = destinyRepository.getReferenceById(idDest);
		newPackage.setDestiny(destiny);		
		ModelAndView mav = new ModelAndView("redirect:/destiny");
		packageRepository.save(newPackage);		
		return mav;
	}
	
	@GetMapping("{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("package/edit");
		List<Destiny> destinys = destinyRepository.findAll();
		mav.addObject("package", packageRepository.getReferenceById(id));
		mav.addObject("destinys", destinys);
		return mav;
	}
	
	@PostMapping("{id}/editar")
	public ModelAndView editar(Package newPackage, @RequestParam("idDest") Long idDest) {
		ModelAndView mav = new ModelAndView("redirect:/destiny");
		Destiny destiny = destinyRepository.getReferenceById(idDest);
		newPackage.setDestiny(destiny);
		packageRepository.save(newPackage);
		return mav;
	}

	@GetMapping("{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("redirect:/destiny");
		packageRepository.deleteById(id);
		return mav;
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
