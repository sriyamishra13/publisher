package com.pubsub.gcp.publisher;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.DataInput;
import java.io.IOException;

@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    public ProductRepository productRepository;

    public void persistProductDetails(ProductData productData) {
       // ModelMapper modelMapper = new ModelMapper();
        Product product = new Product();
        product.setCategory(productData.getCATEGORY());
        product.setConsole(productData.getCONSOLE());
        product.setPublisher(productData.getPUBLISHER());
        product.setCriticsPoints(productData.getCRITICS_POINTS());
        product.setRating(productData.getRATING());
        product.setUserPoints(productData.getUSER_POINTS());
        product.setYear(productData.getYEAR());

       /* Product product = Product.builder().category(productData.getCATEGORY())
                .publisher(productData.getPUBLISHER())
                .criticsPoints(productData.getCRITICS_POINTS())
                .category(productData.getCATEGORY())
                .rating(productData.getRATING())
                .userPoints(productData.getUSER_POINTS())
                .year(productData.getYEAR())
                .build();*/
        productRepository.save(product);
    }



    private Product convert(ProductData payload) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(payload.toString(), Product.class);
    }
}
