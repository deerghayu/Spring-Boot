package com.example.restapi.restapi.controller;

import com.example.restapi.restapi.model.Product;
import com.example.restapi.restapi.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/products/")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private ProductRepository productRepository;

    @Autowired
    public void productRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable(name = "id") String id) {
        return productRepository.getOne(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product updateProduct(@RequestBody Product product, @PathVariable(name = "id") String id) {

        Product foundProduct = productRepository.getOne(id);
        if (foundProduct != null) {
            foundProduct.setName(product.getName());
            foundProduct.setCategory(product.getCategory());
            foundProduct.setDescription(product.getDescription());
            productRepository.save(foundProduct);
            return foundProduct;
        } else {
            logger.info("No product found with given id");
            return product;
        }


    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable(value = "id") String id) {
        Product product = productRepository.getOne(id);
        if (product != null) {
            productRepository.delete(product);
        }

    }
}
