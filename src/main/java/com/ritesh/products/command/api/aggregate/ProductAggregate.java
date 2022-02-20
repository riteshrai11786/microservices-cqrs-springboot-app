package com.ritesh.products.command.api.aggregate;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.ritesh.products.command.api.commands.CreateProductCommand;
import com.ritesh.products.command.api.events.ProductCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand){

        // Create the product created event object
        ProductCreatedEvent productCreatedEvent =
               new ProductCreatedEvent();
        // Copy the create commands into the event object
        BeanUtils.copyProperties(createProductCommand,productCreatedEvent);
        // Apply aggreagate lifcycle
        AggregateLifecycle.apply(productCreatedEvent);

    }

    public ProductAggregate(){
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent){
        //Set all the changed properties to handle the changes
        this.productId = productCreatedEvent.getProductId();
        this.name = productCreatedEvent.getName();
        this.price = productCreatedEvent.getPrice();
        this.quantity = productCreatedEvent.getQuantity();
    }
}
