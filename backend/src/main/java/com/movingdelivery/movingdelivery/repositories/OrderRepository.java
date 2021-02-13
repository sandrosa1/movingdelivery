package com.movingdelivery.movingdelivery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.movingdelivery.movingdelivery.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	//Linguagem para consulta e o jpql
	//Nessa ligaguem tem que dar apelidos para os objetos que vc for buscar
	//Na hora de utilizar o From coloque exatamente o nome da class
	//Na frente do FETCH coloca se qual atributo representa a associação.
	@Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products "
	+" WHERE obj.status = 0 ORDER BY obj.moment ASC")
	List<Order> findOrdesSwithProducts();

}

