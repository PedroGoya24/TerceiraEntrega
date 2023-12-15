package com.adois.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adois.models.Client;
import com.adois.repositoryes.ClientRepository;
import com.adois.util.accesLevel;

@Controller
@RequestMapping("/client")
public class ClientController {
	

	@Autowired
	private ClientRepository clientRepository;
	
	
	private accesLevel accesLevel;
	
	@GetMapping
	public ModelAndView listClient() {
		ModelAndView mav = new ModelAndView("client/listClient.html");
		List<Client> clients = clientRepository.findByAccesLevel(accesLevel);
		mav.addObject("clients", clients);
		return mav;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarClient() {
		ModelAndView mav = new ModelAndView("client/cad.html");
		mav.addObject("client", new Client());
		return mav;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrarClient(Client client) {
		ModelAndView mav = new ModelAndView("redirect:/client");
		clientRepository.save(client);
		return mav;
	}
	
	@GetMapping("/{id}/detalhes")
	public ModelAndView details(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("client/details");
		Client client = clientRepository.getReferenceById(id);
		mav.addObject("client", client);
		return mav;
	
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/client");
		clientRepository.deleteById(id);
		return modelAndView;
		
	}
	
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("client/edit");
		mav.addObject("client", clientRepository.getReferenceById(id));
		return mav;
	}
	
	@PostMapping("/{id}/editar")
	public ModelAndView editar(Client client) {
		ModelAndView mav = new ModelAndView("redirect:/client");
		clientRepository.save(client);
		return mav;
	}	
	
	
	
	
	
	
	
	
	
}
