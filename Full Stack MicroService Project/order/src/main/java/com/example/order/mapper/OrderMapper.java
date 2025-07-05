package com.example.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.order.dto.OrderDTO;
import com.example.order.entity.Order;

@Mapper
public interface OrderMapper {

	OrderMapper INSTANCE=Mappers.getMapper(OrderMapper.class);
	Order mapOrderToOrderDTO(OrderDTO orderDTO);
	OrderDTO mapOrderDTOToOrder(Order order);
}
