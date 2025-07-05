package com.example.order.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.dto.OrderDTO;
import com.example.order.dto.OrderDTOFromFE;
import com.example.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
private OrderService orderService;
	
	@PostMapping("/saveOrder")
	public ResponseEntity<OrderDTO>saveOrder(@RequestBody OrderDTOFromFE orderDetails) throws URISyntaxException
	{
		OrderDTO savedObjectOrder=orderService.saveOrderObject(orderDetails);
		return new ResponseEntity<OrderDTO>(HttpStatus.CREATED);
		
	}
}
