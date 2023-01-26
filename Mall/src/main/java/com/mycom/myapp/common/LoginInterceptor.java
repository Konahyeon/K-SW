package com.mycom.myapp.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mycom.myapp.dto.UserDto;

@Component //이게 있어야 spring이 인식하고 객체 만들어서 Dependency Injection 해줄 수 있음
public class LoginInterceptor implements HandlerInterceptor { //로그인 안 되어있을 때 로그인창으로 돌아가도록 하는 클래스
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("<<<<< Interceptor 들어옴");

        //UserController에서 로그인 성공 시 session에 UserDto 객체 넣어놓았었음
        HttpSession session = request.getSession();
        UserDto userDto = (UserDto) session.getAttribute("userDto");
        if( userDto == null ) { //로그인 안 한 상태

            System.out.println("<<<<< Interceptor ==> login이 필요합니다.");

        	response.sendRedirect("/login"); //브라우저로 하여금 /login(로그인 페이지)으로 접속하도록 함
        	return false;
        }

        return true; //로그인 한 상태
    }
}
