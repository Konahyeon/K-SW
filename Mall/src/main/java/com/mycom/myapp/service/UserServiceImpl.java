package com.mycom.myapp.service;

import com.mycom.myapp.dao.UserDao;
import com.mycom.myapp.dto.UserDto;
import com.mycom.myapp.dto.UserResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public UserResultDto userRegister(UserDto userDto) {
        UserResultDto userResultDto = new UserResultDto();

        int result = userDao.userRegister(userDto);
        userResultDto.setResult(result);

        return userResultDto;
    }

    @Override
    public UserDto login(UserDto dto) {
        return null;
    }


}
