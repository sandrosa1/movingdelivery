package com.movingdelivery.movingdelivery.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	//Criando end point para salvar
	//Retornar code 201
	@PostMapping
	public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
