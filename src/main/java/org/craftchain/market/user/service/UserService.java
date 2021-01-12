package org.craftchain.market.user.service;

import org.craftchain.market.user.entity.User;
import org.craftchain.market.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User createUser(User user) {
        return repository.save(user);
    }

}
