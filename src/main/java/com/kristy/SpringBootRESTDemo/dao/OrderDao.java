package com.kristy.SpringBootRESTDemo.dao;

import org.springframework.data.repository.CrudRepository;

import com.kristy.SpringBootRESTDemo.bean.Order;

public interface OrderDao  extends CrudRepository<Order, Integer>{

}
