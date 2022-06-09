package com.codewithabdel.productservice.controller;

import com.codewithabdel.productservice.model.Product;
import com.codewithabdel.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private  ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product product){
        Product savedProduct = productService.saveProduct(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(savedProduct.getId())
                .toUri();
        return  ResponseEntity.created(uri).build();
    }

    @GetMapping("/{idProduct}")
    public Product getById(@PathVariable String idProduct) throws Exception {
        return  productService.getProductById(idProduct);
    }
}
