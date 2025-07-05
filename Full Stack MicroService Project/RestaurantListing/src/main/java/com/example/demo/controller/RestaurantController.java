package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RestaurantDTO;
import com.example.demo.entity.Restaurant;
import com.example.demo.mapper.RestaurantMapper;
import com.example.demo.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	// SLF4J Logger
    private static final Logger logger = LoggerFactory.getLogger(RestaurantController.class);
	
	@GetMapping("/fetchAllRestaurants")
	public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants()
	{
	List<RestaurantDTO> allRestaurants=	restaurantService.findAllRestaurants();
		 return new ResponseEntity<>(allRestaurants,HttpStatus.OK);
	}
	@PostMapping("/addRestaurant")
	public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO)
	{
			RestaurantDTO restaurantAdded =restaurantService.addRestauranttoDB(restaurantDTO);
			return new ResponseEntity<>(restaurantAdded,HttpStatus.CREATED);	
	}
	@GetMapping("/fetchById/{restaurantid}")
	public ResponseEntity<RestaurantDTO> fetchRestaurantById(@PathVariable("restaurantid") Integer id)
	{
		logger.info("Restaurant ID to be fetched is::"+id);
		Optional<Restaurant> getRestaurantObject=restaurantService.findRestaurantById(id);
		if(getRestaurantObject.isPresent())
		{
			return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(getRestaurantObject.get()),HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
}
