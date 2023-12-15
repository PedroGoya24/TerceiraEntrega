package com.adois.controllers;


import java.util.List;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.adois.models.Destiny;
import com.adois.repositoryes.DestinyRepository;

@Controller
@RequestMapping("/destiny")
public class DestinyController {
	
	@Autowired
	private DestinyRepository destinyRepository;
	
	@GetMapping
	public ModelAndView listarDest() {
		ModelAndView mav = new ModelAndView("destiny/list.html");
		
		List<Destiny> destiny = destinyRepository.findAll();
		mav.addObject("destiny", destiny);
		
		return mav;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarDest() {
		ModelAndView mav = new ModelAndView("destiny/cad.html");
		mav.addObject("destiny", new Destiny());
		return mav;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrarDest(Destiny destiny, @RequestParam("fileDestiny") MultipartFile file)throws IOException {
		
		try {
			destiny.setImgDest(file.getBytes());
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView("redirect:/destiny");
		destinyRepository.save(destiny);
		return mav;
	}
	
	@GetMapping("/imgDest/{id}")
	@ResponseBody
	public byte[] exibirImagem(@PathVariable("id") Long id) {
		Destiny destiny = this.destinyRepository.getReferenceById(id);
		return destiny.getImgDest();
	}
	
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("destiny/edit");
		Destiny destiny = destinyRepository.getReferenceById(id);
		mav.addObject("destiny", destiny);
		return mav;
	}
	
	@PostMapping("{id}/editar")
	public ModelAndView editar(Destiny destiny, @RequestParam("fileDestiny") MultipartFile file) {
		try {
			destiny.setImgDest(file.getBytes());
		}catch(IOException e) {
			e.printStackTrace();
		}
		ModelAndView mav =  new ModelAndView("redirect:/destiny");
		destinyRepository.save(destiny);
		return mav;
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("redirect:/destiny");
		destinyRepository.deleteById(id);
		return mav;
	}
	
}

































