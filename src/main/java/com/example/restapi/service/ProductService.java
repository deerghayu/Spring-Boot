package com.example.restapi.service;

import com.example.restapi.controller.ProductController;
import com.example.restapi.model.Product;
import com.example.restapi.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository productRepository;

    public Product getProduct(String id) {
        LOG.info("Getting the product with id:" + id);
        return productRepository.getOne(id);
    }

    public Product saveProduct(Product product) {
        try {
            LOG.info("Saving product");
            return productRepository.save(product);
        } catch (Exception ex) {
            LOG.error("An error during product saving:" + ex.getMessage());
        }
        return new Product();

    }

    public Product updateProduct(Product product, String id) {
        Product foundProduct = productRepository.getOne(id);
        try {
            foundProduct.setName(product.getName());
            foundProduct.setCategory(product.getCategory());
            foundProduct.setDescription(product.getDescription());
            productRepository.save(foundProduct);
        } catch (Exception ex) {
            LOG.error("An error occurred during product update:" + ex.getMessage());
        }
        return product;
    }

    public void deleteProduct(String id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception ex) {
            LOG.error("An error occurred during product delete:" + ex.getMessage());
        }
    }
}
