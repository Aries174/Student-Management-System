package com.hsf301.javafx.studentmanagementsystem.config;

import com.hsf301.javafx.studentmanagementsystem.dto.UserDTO;
import com.hsf301.javafx.studentmanagementsystem.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
    private final UserService userService;
    @Autowired
    public CustomLoginSuccessHandler(UserService userService) {
        this.userService = userService;
    }
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String email = authentication.getName();
        UserDTO user= userService.findByEmail(email);
        HttpSession session = request.getSession();
        session.setAttribute("userID", user.getUserId());
        String contextPath = request.getContextPath();
        Set<String> roles= AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if(roles.contains("ROLE_ADMIN")){
            response.sendRedirect(contextPath+"/admin");
        }else{
            response.sendRedirect(contextPath+"/home");
        }


    }
}
