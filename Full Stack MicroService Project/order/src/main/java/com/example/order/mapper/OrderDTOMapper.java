package com.example.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.order.dto.OrderDTO;
import com.example.order.entity.Order;

@Mapper
public interface OrderDTOMapper {

	OrderDTOMapper INSTANCE=Mappers.getMapper(OrderDTOMapper.class);
	Order mapOrderDTOToOrder(OrderDTO orderDTO);
	OrderDTO mapOrderTOOrderDTO(Order order);
}
