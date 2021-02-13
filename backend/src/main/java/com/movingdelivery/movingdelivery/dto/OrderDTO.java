package com.movingdelivery.movingdelivery.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.movingdelivery.movingdelivery.entities.Order;
import com.movingdelivery.movingdelivery.entities.OrderStatus;

public class OrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String address;
	private Instant moment;
	private OrderStatus status;
	
	private List<ProductDTO> products = new ArrayList<>();
	
	
	public OrderDTO() {
		
	}


	public OrderDTO(Long id, String name, String address, Instant moment, OrderStatus status) {

		this.id = id;
		this.name = name;
		this.address = address;
		this.moment = moment;
		this.status = status;
	}
	
	public OrderDTO(Order entity) {

		id = entity.getId();
		name = entity.getName();
		address = entity.getAddress();
		moment = entity.getMoment();
		status = entity.getStatus();
		products = entity.getProducts().stream()
				.map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Instant getMoment() {
		return moment;
	}


	public void setMoment(Instant moment) {
		this.moment = moment;
	}


	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	public List<ProductDTO> getProducts() {
		return products;
	}


	
	
}
