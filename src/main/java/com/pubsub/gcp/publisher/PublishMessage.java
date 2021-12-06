package com.pubsub.gcp.publisher;

import com.google.cloud.spring.pubsub.core.publisher.PubSubPublisherTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

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
    void pushProductDetails(@RequestBody ProductData message) throws ExecutionException, InterruptedException {
        System.out.println(message);
        //keep this below publish
        String messageId = pubSubPublisherTemplate.publish("product-pubsub", message).get();
        System.out.println("Message published with ID: " + messageId);
        productService.persistProductDetails(message);
    }

}
