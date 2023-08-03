package com.kevin.testproj.domain.repository;

import com.kevin.testproj.domain.entity.UserEntity;
import com.kevin.testproj.user.controller.dto.ResponseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Query(value = "select t.* from TBL_USER_M t " +
            "where (:userId is null or t.USER_ID=:userId) " +
            "and (:userNm is null or t.USER_NM=:userNm)", nativeQuery = true)
    List<UserEntity> srchUser(@Param("userId")String userId, @Param("userNm")String userNm);
}
