package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Alan.Juan
 *
 */
@RestController
@ApiIgnore
public class LoginController {
    
    @RequestMapping(value = "/loginProcess")
    public String login(
            @AuthenticationPrincipal UserDetails userDetail,
            HttpServletRequest request
    ) {
        return " welcome: " + userDetail.getUsername();
    }
}
