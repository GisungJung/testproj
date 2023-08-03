package com.kevin.testproj.user.controller.dto;

import com.kevin.testproj.domain.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUser {

    private String userId;
    private String userNm;
    private String userTel;
    private String post;
    private String userAddr1;
    private String userAddr2;

    public ResponseUser toDto(UserEntity userEntity){
        return ResponseUser.builder()
                .userId(userEntity.getUserId())
                .userNm(userEntity.getUserNm())
                .userTel(userEntity.getUserTel())
                .post(userEntity.getPost())
                .userAddr1(userEntity.getUserAddr1())
                .userAddr2(userEntity.getUserAddr2())
                .build();
    }
}
