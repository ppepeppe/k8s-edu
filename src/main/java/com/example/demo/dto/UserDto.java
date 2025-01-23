package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.example.demo.dto
 * fileName       : UserDto
 * author         : doong2s
 * date           : 2025. 1. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 1. 12.        doong2s       최초 생성
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String userNo;
    private String userName;
    private String goodsNo;
}
