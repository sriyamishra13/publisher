package com.pubsub.gcp.publisher;

import com.google.cloud.spring.pubsub.core.publisher.PubSubPublisherTemplate;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PublishMessage {
    @Autowired
    private final PubSubPublisherTemplate pubSubPublisherTemplate;

    @Autowired
    private ProductService productService;

    PublishMessage(PubSubPublisherTemplate pubSubPublisherTemplate) {
       this.pubSubPublisherTemplate = pubSubPublisherTemplate;
    }

    @PostMapping("/product-details")
    void pushProductDetails(@RequestBody ProductData message) {
        System.out.println(message);
        //keep this below publish
        pubSubPublisherTemplate.publish("product-pubsub", message);
        productService.persistProductDetails(message);
    }

}
