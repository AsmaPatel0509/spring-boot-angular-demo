package com.ibm.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.model.Customer;

public interface CustomerDAO extends MongoRepository<Customer, Integer>{

}
