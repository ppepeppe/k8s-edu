package com.example.demo.controller;

import com.example.demo.dto.GoodsResponseDto;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * packageName    : com.example.demo.controller
 * fileName       : UserRestController
 * author         : doong2s
 * date           : 2025. 1. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 1. 12.        doong2s       최초 생성
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserRestController {

    @Autowired
    private UserService userService;
    @Value("${goods.service.url}")
    private String goodsServiceUrl;
    @GetMapping("/{userNo}")
    public ResponseEntity<UserResponseDto> getUserByuserNo(@PathVariable String userNo) {
        UserDto userDto = userService.getUserByuserNo(userNo);
        GoodsResponseDto goodsResponseDto = callGoodsApi(userDto.getGoodsNo());
        UserResponseDto userResponseDto = UserResponseDto.builder()
                .userName(userDto.getUserName())
                .userNo(userDto.getUserNo())
                .goodsNo(goodsResponseDto.getGoodsNo())
                .goodsName(goodsResponseDto.getGoodsName())
                .build();
        return ResponseEntity.ok(userResponseDto);

    }

    private GoodsResponseDto callGoodsApi(String goodsNo) {
        // localhost에서 goods 서비스 호출
        String goodsApiUrl = goodsServiceUrl + "/" + goodsNo;
//        String goodsApiUrl =   "http://localhost/api/v1/goods/" + goodsNo;
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(goodsApiUrl, GoodsResponseDto.class);
    }
}
