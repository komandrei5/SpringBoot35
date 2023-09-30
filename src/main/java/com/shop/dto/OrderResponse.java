package com.shop.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OrderResponse {

    private String name;

    private List<ProductDto> products;


}
