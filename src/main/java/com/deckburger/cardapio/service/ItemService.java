package com.deckburger.cardapio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.deckburger.cardapio.dto.ItemDto;
import com.deckburger.cardapio.model.Item;
import com.deckburger.cardapio.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	public String criarItem(ItemDto itemDto, MultipartFile file) throws Exception {
		
		byte[] imagem = file.getBytes();
		
		Item item = new Item();
		
		item.setTitulo(itemDto.getTitulo());
		item.setPreco(itemDto.getPreco());
		item.setDescricao(itemDto.getDescricao());
		item.setClassificacao(itemDto.getClassificacao());
		item.setImagem(imagem);
		itemRepository.save(item);
		
		return "";
		
	}
	
	public List<Item> findAll(){
		
		return itemRepository.findAll();
		
	}
	
	public String deletarItem(Long id) {
		
		itemRepository.deleteById(id);
		return "redirect:/";
	}
	
}
