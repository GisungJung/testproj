package com.kevin.testproj.user.controller;

import com.kevin.testproj.common.dto.APIResponse;
import com.kevin.testproj.user.controller.dto.RequestUserSave;
import com.kevin.testproj.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/api")
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/user")
    public ResponseEntity<APIResponse> saveUser(@RequestBody RequestUserSave requestUserSave){
        return ResponseEntity.status(HttpStatus.OK).body(APIResponse.of(userService.saveUser(requestUserSave)));
    }
    @GetMapping(value = "/user")
    public ResponseEntity<APIResponse> srchUser(@RequestParam(name = "userId", required = false) String userId
            , @RequestParam(name = "userNm", required = false) String userNm){
        return ResponseEntity.status(HttpStatus.OK).body(APIResponse.of(userService.srchUser(userId,userNm)));
    }

}
