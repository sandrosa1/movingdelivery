package com.movingdelivery.movingdelivery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movingdelivery.movingdelivery.dto.ProductDTO;
import com.movingdelivery.movingdelivery.services.ProductService;

//Controlador rest

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	//Criando end point para metodo get HTTP
	//Quando o retorno for 200 return .ok()com a lista
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findall(){
		List<ProductDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
