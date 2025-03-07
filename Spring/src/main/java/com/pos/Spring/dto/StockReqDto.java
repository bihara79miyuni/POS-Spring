package com.pos.Spring.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockReqDto {
    private LocalDateTime updatedAt;
    private int quantity;
    private Long itemId;
}
