package com.ritesh.products.command.api.events;

import com.ritesh.products.command.api.entity.Product;
import com.ritesh.products.command.api.repository.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventsHandler {

    private ProductRepository productRepository;

    public ProductEventsHandler(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent){
        Product product = new Product();
        BeanUtils.copyProperties(productCreatedEvent,product);
        productRepository.save(product);
    }
}
