package com.movingdelivery.movingdelivery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movingdelivery.movingdelivery.dto.OrderDTO;
import com.movingdelivery.movingdelivery.services.OrderService;

//Controlador rest

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	//Criando end point para metodo get HTTP
	//Quando o retorno for 200 return .ok()com a lista
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findall(){
		List<OrderDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
