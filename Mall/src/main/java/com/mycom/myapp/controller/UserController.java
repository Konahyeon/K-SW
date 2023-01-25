package com.mycom.myapp.controller;

import com.mycom.myapp.dto.UserDto;
import com.mycom.myapp.dto.UserResultDto;
import com.mycom.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value="/register")
    public Map<String, String> register(UserDto dto){

        //UserServiceImpl과 연결되어 있는 코드. db에 이메일에 해당하는 사람 없거나 비밀번호 틀렸을 경우 null을 리턴
        UserResultDto userResultDto = userService.userRegister(dto);

        Map<String, String> map = new HashMap<>();
        if( userResultDto.getResult() == 1 ) {
            map.put("result", "success");
        }else {
            map.put("result", "fail");
        }

        return map;
    }

    @PostMapping(value="/login")
    public Map<String, String> login(UserDto dto, HttpSession session){

        UserDto userDto = userService.login(dto);
        Map<String, String> map = new HashMap<>();
        if( userDto != null ) {
            session.setAttribute("userDto", userDto); //로그인 성공 시 사용자 정보 저장한 객체 담음
            map.put("userName", userDto.getUserName());
            map.put("userProfileImageUrl", userDto.getUserProfileImageUrl());
            map.put("result", "success");
        }else {
            map.put("result", "fail");
        }

        return map;
    }
}
