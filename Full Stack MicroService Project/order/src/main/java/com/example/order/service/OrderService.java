package com.example.order.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.order.dto.OrderDTO;
import com.example.order.dto.OrderDTOFromFE;
import com.example.order.dto.UserDTO;
import com.example.order.entity.Order;
import com.example.order.mapper.OrderMapper;
import com.example.order.repository.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private SequenceGenerator sequenceGenerator;
	@Autowired
	 RestTemplate restTemplate;
	public OrderDTO saveOrderObject(OrderDTOFromFE orderDTOfromFEObj) throws URISyntaxException {
	Integer newOrderId=sequenceGenerator.generateNextOrderId();
	UserDTO userDTOObject=fetchUserIdDetailsFromUserId(orderDTOfromFEObj.getUserId());
Order orderToBeSaved=new Order(newOrderId,orderDTOfromFEObj.getFoodItemDto(),
		orderDTOfromFEObj.getRestaurant(),userDTOObject);
		orderRepo.save(orderToBeSaved);
		return OrderMapper.INSTANCE.mapOrderDTOToOrder(orderToBeSaved);
		
	}

	private UserDTO fetchUserIdDetailsFromUserId(Integer userId) throws URISyntaxException {
		// TODO Auto-generated method stub
		String url = "http://USER-INFO-SERVICE/user/fetchUserById/" + userId; // Replace with the correct URL
		URI urIOBject=new URI(url);
		UserDTO getUserDTOObject=restTemplate.getForObject(urIOBject, UserDTO.class);
		return getUserDTOObject;
	}
}
