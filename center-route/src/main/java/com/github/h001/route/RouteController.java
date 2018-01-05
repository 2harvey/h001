package com.github.h001.route;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class RouteController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "退出成功";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(HttpServletRequest request) throws ServletException {
        return "没有权限";
    }

}
