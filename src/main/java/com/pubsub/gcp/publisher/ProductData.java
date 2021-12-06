package com.pubsub.gcp.publisher;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductData {
    //public Long id;
    public Integer YEAR;
    public String CONSOLE;
    public String PUBLISHER;
    public Double CRITICS_POINTS;
    public String CATEGORY;
    public String RATING;
    public Integer USER_POINTS;
}
