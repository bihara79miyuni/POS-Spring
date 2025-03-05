package com.pos.Spring.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.pos.Spring.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionReqDto {
    private LocalDateTime createdAt;
    private int totalAmount;
    private User userId;
    private List<Long> itemIds;
}
