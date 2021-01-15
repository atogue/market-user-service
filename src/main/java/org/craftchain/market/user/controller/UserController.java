package org.craftchain.market.user.controller;

import org.craftchain.market.user.common.TransactionRequest;
import org.craftchain.market.user.common.TransactionResponse;
import org.craftchain.market.user.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public TransactionResponse createUser(@RequestBody TransactionRequest request) {
        return service.createUser(request);
    }
}
