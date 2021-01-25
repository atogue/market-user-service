package org.craftchain.market.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.craftchain.market.user.common.TransactionRequest;
import org.craftchain.market.user.common.TransactionResponse;
import org.craftchain.market.user.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserService service;
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public TransactionResponse createUser(@RequestBody TransactionRequest request) {
        TransactionResponse response = null;
        try {
            response = service.createUser(request);
        } catch (JsonProcessingException err) {
            log.error("UserService createUser ERROR : ", err);
        }
        return response;
    }
}
