package com.example.resserver.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/token")
@RestController
public class TokenApi {
    @GetMapping
    public void getToken(HttpServletRequest request) {
        System.out.println("token");
    }
}
