package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RestaurantDTO;
import com.example.demo.entity.Restaurant;
import com.example.demo.mapper.RestaurantMapper;
import com.example.demo.repository.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	public List<RestaurantDTO> findAllRestaurants() {
		List<Restaurant> getAllRestaurants=restaurantRepository.findAll();
		List<RestaurantDTO> restaurantDTOList=getAllRestaurants.stream().map(restaurant->RestaurantMapper.INSTANCE
				.mapRestaurantToRestaurantDTO(restaurant)).collect(Collectors.toList());
		return restaurantDTOList;
	}

	public RestaurantDTO addRestauranttoDB(RestaurantDTO restaurantDTO) {
		// TODO Auto-generated method stub
		Restaurant restauranttobeAdded=restaurantRepository.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));
		
		return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restauranttobeAdded);
	}

	public Optional<Restaurant> findRestaurantById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Restaurant> getRestaurantObject=restaurantRepository.findById(id);
		return getRestaurantObject;
	}
}
