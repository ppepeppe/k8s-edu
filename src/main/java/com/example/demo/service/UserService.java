package com.example.demo.service;

import com.example.demo.dto.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.example.demo.service
 * fileName       : UserService
 * author         : doong2s
 * date           : 2025. 1. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 1. 12.        doong2s       최초 생성
 */
@Service
public class UserService {

    String appRunType;

    public UserService(@Value("${app.run.type}") String appRunType) {
        this.appRunType = appRunType;
    }

    public UserDto getUserByuserNo(String userNo) {

        UserDto userDto = UserDto.builder()
                .userNo(userNo)
                .userName("user-" + appRunType + "-" + userNo)
                .goodsNo(userNo)
                .build();
        return userDto;
    }
}
