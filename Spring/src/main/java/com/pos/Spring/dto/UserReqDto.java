package com.pos.Spring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReqDto {
    private Long id;
    private String username;
    private String role;
}
