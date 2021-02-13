package com.movingdelivery.movingdelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movingdelivery.movingdelivery.dto.OrderDTO;
import com.movingdelivery.movingdelivery.entities.Order;
import com.movingdelivery.movingdelivery.repositories.OrderRepository;


//Primeira ingeção de dependencia de componentes
@Service
public class OrderService { 
	
	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> list = repository.findOrdesSwithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	

}
