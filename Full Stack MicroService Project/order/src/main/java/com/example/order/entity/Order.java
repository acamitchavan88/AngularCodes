package com.example.order.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.order.dto.FoodItemDTO;
import com.example.order.dto.Restaurant;
import com.example.order.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection ="order")
public class Order {
private Integer orderId;
private List<FoodItemDTO>foodItemDTOList;
private Restaurant restaurant;
private UserDTO userDTO;
}
