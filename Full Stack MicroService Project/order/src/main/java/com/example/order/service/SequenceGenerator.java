package com.example.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.order.entity.Sequence;

@Service
public class SequenceGenerator {
@Autowired
	private MongoOperations mongoOperations;

/* public int generateNextOrderId() {
	 
	/* Sequence counter=mongoOperations.findAndModify(query(where("_id")
			 .is("sequence")), new Update().inc("sequence",1),
			 options().returnNew(true).upsert(true),Sequence.class);
	return counter.getSequence();
	 
	 
 }*/
public int generateNextOrderId() {
    // Create a query to find the sequence by ID
    Query query = new Query(Criteria.where("_id").is("sequence"));

    // Define the update operation to increment the sequence value by 1
    Update update = new Update().inc("sequence", 1);

    // Define options to return the new updated document and upsert if it does not exist
    FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(true);

    // Perform the find-and-modify operation
    Sequence counter = mongoOperations.findAndModify(query, update, options, Sequence.class);

    // Handle the possibility of a null response
    if (counter != null) {
        return counter.getSequence();
    } else {
        throw new RuntimeException("Unable to generate sequence ID");
    }
}
}
