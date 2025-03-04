package com.pos.Spring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemReqDto {
    private String name;
    private String description;
    private double price;
    private Long itemCategoryId;
}
