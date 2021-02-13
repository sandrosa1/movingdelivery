package com.movingdelivery.movingdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movingdelivery.movingdelivery.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

