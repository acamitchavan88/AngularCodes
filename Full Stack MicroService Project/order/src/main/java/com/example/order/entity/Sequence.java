package com.example.order.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection ="sequence")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sequence {
	@Id
	private String id;
	private int sequence;

}
