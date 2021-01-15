package org.craftchain.market.user.service;

import org.craftchain.market.user.common.TransactionRequest;
import org.craftchain.market.user.common.TransactionResponse;
import org.craftchain.market.user.entity.User;
import org.craftchain.market.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final UserRepository repository;
    private final RestTemplate template;
    public UserService(UserRepository repository, RestTemplate template) {
        this.repository = repository;
        this.template = template;
    }

    public TransactionResponse createUser(TransactionRequest request) {
        User user = request.getUser();
        request.getOrder().setClientId(user.getUserId());
        // rest call to order service
        TransactionResponse response = template.postForObject("http://ORDER-SERVICE/order/bookOrder", request, TransactionResponse.class);
        repository.save(user);
        if (response != null) {
            response.setUser(user);
        }
        return response;
    }

}
