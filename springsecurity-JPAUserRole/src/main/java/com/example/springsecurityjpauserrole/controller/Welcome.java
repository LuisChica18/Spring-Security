package com.example.springsecurityjpauserrole.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @GetMapping("/")
    public String index() {
        return "<h1>Welcome</h1>";
    }

    @GetMapping("/user")
    public String user() {
        return "<h1>Welcome User</h1>";
    }

    @GetMapping("/admin")
    public String admin() {
        return "<h1>Welcome Admin</h1>";
    }

    @GetMapping("/moderator")
    public String moderator() {
        return "<h1>Welcome Moderator</h1>";
    }

    @GetMapping("/denyall")
    public String denyAll() {
        return "<h1>Deny For All!</h1>";
    }
}
