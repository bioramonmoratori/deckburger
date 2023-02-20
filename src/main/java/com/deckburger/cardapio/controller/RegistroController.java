package com.deckburger.cardapio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.deckburger.cardapio.dto.ItemDto;
import com.deckburger.cardapio.model.Item;
import com.deckburger.cardapio.service.ItemService;

@Controller
public class RegistroController {
	
	@Autowired
	ItemService itemService;
	
	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public String dashboard(Model model) {
		
		List<Item> listaDeItens = itemService.findAll();
		
		model.addAttribute("listadeitens", listaDeItens);
		
		return "dashboard";
	}
	
	
	@RequestMapping(value="/criaritem", method=RequestMethod.GET)
	public String criarItem(ItemDto itemDto) {
		
		return "criaritem";
	}
	
	@RequestMapping(value = "/salvaritem", method = RequestMethod.POST)
    public String salvarItem(@RequestParam("file") MultipartFile file, ItemDto itemDto, Model model, HttpServletRequest request) throws IOException {
        
		try {
			itemService.criarItem(itemDto, file);
		} catch(Exception e) {
			return "erro";
		}
        return "redirect:/dashboard";
    }
	
	@RequestMapping(value="/deletaritem/{id}", method=RequestMethod.GET)
	public String deletarItem(@PathVariable Long id) {
		
		itemService.deletarItem(id);
		
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String cardapio(Model model) {
		
		List<Item> listaDeItens = itemService.findAll();
		
		model.addAttribute("listadeitens", listaDeItens);
		
		return "cardapio";
	}
	
}
