package com.example.restapi;

import com.example.restapi.model.Product;
import com.example.restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestapiApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        Product p1 = new Product();
        p1.setCategory("category1");
        p1.setDescription("desc1");
        p1.setName("prod1");
        p1.setPrice(1.3);
        p1.setType("type");

        productRepository.save(p1);

        Product p2 = new Product();
        p2.setCategory("category2");
        p2.setDescription("desc2");
        p2.setName("prod2");
        p2.setPrice(1.4);
        p2.setType("type");

        productRepository.save(p2);

        /*List<Product> productList = productRepository.findAll();
        for(Product product: productList){
            logger.info("Products found:" + product.toString());
        }*/

       /* List<Product> typeProduct = productRepository.findByType("type");
        for(Product product: typeProduct){
            logger.info("Products found3333333333:" + product.toString());
        }*/
       // productRepository.delete(p1);
    }
}
