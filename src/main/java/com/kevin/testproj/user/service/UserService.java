package com.kevin.testproj.user.service;

import com.kevin.testproj.domain.repository.UserRepository;
import com.kevin.testproj.user.controller.dto.RequestUserSave;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    @Transactional
    public boolean saveUser(RequestUserSave requestUserSave) {
        userRepository.save(requestUserSave.toEntity());
        return true;
    }
}
