package com.kevin.testproj.user.controller.dto;

import com.kevin.testproj.domain.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestUserSave {
    private String userId;
    private String userNm;
    private String userPw;
    private String userTel;
    private String post;
    private String userAddr1;
    private String userAddr2;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .userId(userId)
                .userNm(userNm)
                .userPw(userPw)
                .userTel(userTel)
                .post(post)
                .userAddr1(userAddr1)
                .userAddr2(userAddr2)
                .build();
    }
}
