package com.example.resserver.api;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/api/details")
public class HomeController {
    @GetMapping
    @Produces(MediaType.APPLICATION_JSON)
    public Authentication getDetails() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
