package com.kevin.testproj.user.service;

import com.kevin.testproj.domain.entity.UserEntity;
import com.kevin.testproj.domain.repository.UserRepository;
import com.kevin.testproj.user.controller.dto.RequestUserSave;
import com.kevin.testproj.user.controller.dto.ResponseUser;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    @Transactional
    public boolean saveUser(RequestUserSave requestUserSave) {
        userRepository.save(requestUserSave.toEntity());
        return true;
    }

    public List<ResponseUser> srchUser(String userId, String userNm) {
       List<UserEntity> userList = userRepository.srchUser(userId, userNm);
       ResponseUser responseUsers = new ResponseUser();
       List<ResponseUser> responseUserList = new ArrayList<>();
       for(UserEntity a : userList){
           ResponseUser res = responseUsers.toDto(a);
           responseUserList.add(res);
       }
       return responseUserList;
    }
}
