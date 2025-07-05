package com.example.order.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTOFromFE {
	private List<FoodItemDTO> foodItemDto;
	private Integer userId;
	private Restaurant restaurant;
}
