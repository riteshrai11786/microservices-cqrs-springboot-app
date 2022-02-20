package com.ritesh.products.query.api.projection;

import com.ritesh.products.command.api.entity.Product;
import com.ritesh.products.command.api.model.ProductRestModel;
import com.ritesh.products.command.api.repository.ProductRepository;
import com.ritesh.products.query.api.queries.GetProductQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductProjection {

    private final ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductRestModel> handle(GetProductQuery getProductQuery) {
        List<Product> products =
                productRepository.findAll();

        List<ProductRestModel> productRestModels =
                products.stream()
                        .map(product -> ProductRestModel
                                .builder()
                                .quantity(product.getQuantity())
                                .price(product.getPrice())
                                .name(product.getName())
                                .build())
                        .collect(Collectors.toList());

        return productRestModels;
    }
}
