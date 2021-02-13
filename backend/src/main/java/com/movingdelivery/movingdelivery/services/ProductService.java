package com.movingdelivery.movingdelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movingdelivery.movingdelivery.dto.ProductDTO;
import com.movingdelivery.movingdelivery.entities.Product;
import com.movingdelivery.movingdelivery.repositories.ProductRepository;


//Primeira ingeção de dependencia de componentes
@Service
public class ProductService { 
	
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll(){
		List<Product> list = repository.findAllByOrderByNameAsc();
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}


}
