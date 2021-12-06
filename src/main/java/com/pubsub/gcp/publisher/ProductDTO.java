package com.pubsub.gcp.publisher;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductDTO {

    public String console;
    public Integer publisher;
    public Integer criticsPoints;
    public Integer category;
    public Integer rating;
    public Integer userPoints;
    public Integer year;

}
