package com.deckburger.cardapio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deckburger.cardapio.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
