package com.codewithabdel.productservice.repository;

import com.codewithabdel.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
