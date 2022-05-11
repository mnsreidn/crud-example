package com.example.thymeleaf.repository;

import org.springframework.stereotype.Repository;

import com.example.thymeleaf.model.OrderNotifItem;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface OrderNotifRepository extends CrudRepository<OrderNotifItem, Integer> {

}
