package org.craftchain.market.user.controller;

import org.craftchain.market.user.entity.User;
import org.craftchain.market.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }
}
