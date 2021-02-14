package com.movingdelivery.movingdelivery.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movingdelivery.movingdelivery.dto.OrderDTO;
import com.movingdelivery.movingdelivery.dto.ProductDTO;
import com.movingdelivery.movingdelivery.entities.Order;
import com.movingdelivery.movingdelivery.entities.OrderStatus;
import com.movingdelivery.movingdelivery.entities.Product;
import com.movingdelivery.movingdelivery.repositories.OrderRepository;
import com.movingdelivery.movingdelivery.repositories.ProductRepository;


//Primeira ingeção de dependencia de componentes
@Service
public class OrderService { 
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> list = repository.findOrdesSwithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	
	//Metodo para inserir um novo pedido
	@Transactional
	public OrderDTO insert(OrderDTO dto){
		Order order = new Order(null, dto.getName(), dto.getAddress(), Instant.now(), OrderStatus.PENDING);
		
		for (ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		order = repository.save(order);
		return new OrderDTO(order);
	}
	

}
