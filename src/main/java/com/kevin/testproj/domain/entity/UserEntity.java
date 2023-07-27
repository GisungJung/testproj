package com.kevin.testproj.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TBL_USER_M", schema = "testproj", catalog = "")
public class UserEntity {
    @Id
    @Column(name="USER_ID")
    private String userId;
    @Column(name="USER_NM")
    private String userNm;
    @Column(name="USER_PW")
    private String userPw;
    @Column(name="USER_TEL")
    private String userTel;
    @Column(name="POST")
    private String post;
    @Column(name="USER_ADDR1")
    private String userAddr1;
    @Column(name="USER_ADDR2")
    private String userAddr2;
}
