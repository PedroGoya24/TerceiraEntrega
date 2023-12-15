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

import com.adois.models.Client;
import com.adois.models.Purchase;
import com.adois.models.Package;
import com.adois.repositoryes.ClientRepository;
import com.adois.repositoryes.PackageRepository;
import com.adois.repositoryes.PurchaseRepository;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired 
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private PackageRepository packageRepository;
	
	@GetMapping("{id}/listar")
	public ModelAndView listarPurchase(@PathVariable("id") Long id) {
		Client client = clientRepository.getReferenceById(id);
		ModelAndView mav = new ModelAndView("purchase/listPurchase.html");
		List<Purchase> purchases = purchaseRepository.findAllByIdClient(id);
		mav.addObject("purchases", purchases);
		mav.addObject("client", client);
		return mav;
	}
	
	@GetMapping("{id}/cadastrar")
	public ModelAndView cadastrar(@PathVariable("id") Long id) {
		Purchase purchase = new Purchase();
		List<Client> clients = clientRepository.findAll();
		List<Package> newPackages = packageRepository.findAll();
		ModelAndView mav = new ModelAndView("purchase/cad.html");
		mav.addObject("purchase", purchase);
		mav.addObject("clients", clients);
		mav.addObject("newPackages", newPackages);
		return mav;
	}
	
	@PostMapping("{id}/cadastrar")
	public ModelAndView cadastrar(@PathVariable("id") Long id,
								  @ModelAttribute Purchase purchase,
								  @RequestParam("idUser") Long idUser,
								  @RequestParam("newPackage") Long idPackage) {
		Client client = clientRepository.getReferenceById(idUser);
		Package newPackage = packageRepository.getReferenceById(idPackage);
		purchase.setUser(client);
		purchase.setNewPackage(newPackage);
		ModelAndView mav = new ModelAndView("redirect:/client");
		purchaseRepository.save(purchase);
		return mav;
		
	}
	
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("purchase/edit");
		List<Client> clients = clientRepository.findAll();
		List<Package> newPackages = packageRepository.findAll();
		mav.addObject("clients", clients);
		mav.addObject("newPackages", newPackages);
		mav.addObject("purchase", purchaseRepository.getReferenceById(id));		
		return mav;
	}
	
	@PostMapping("{id}/editar")
	public ModelAndView editar() {
//		Purchase purchase, 
//		   @RequestParam("idUser") Long idUser,
//		   @RequestParam("newPackage") Long idPackage
		ModelAndView mav = new ModelAndView("redirect:/client");
//		Client client = clientRepository.getReferenceById(idUser);
//		Package newPackage = packageRepository.getReferenceById(idPackage);
//		purchase.setUser(client);
//		purchase.setNewPackage(newPackage);
//		purchaseRepository.save(purchase);
		return mav;
	}	

	@GetMapping("{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("redirect:/client");
		purchaseRepository.deleteById(id);
		return mav;
				
	}
	
	
	
}

