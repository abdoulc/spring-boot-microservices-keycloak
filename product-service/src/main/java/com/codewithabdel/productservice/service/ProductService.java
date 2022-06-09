package com.codewithabdel.productservice.service;

import com.codewithabdel.productservice.model.Product;
import com.codewithabdel.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public  Product getProductById(String id) throws Exception {
        return productRepository.findById(id).orElseThrow(()-> new Exception("product not found"));
    }
}
