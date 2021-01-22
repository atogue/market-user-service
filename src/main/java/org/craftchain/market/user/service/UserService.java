package org.craftchain.market.user.service;

import org.craftchain.market.user.common.TransactionRequest;
import org.craftchain.market.user.common.TransactionResponse;
import org.craftchain.market.user.entity.User;
import org.craftchain.market.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RefreshScope
public class UserService {

    @Value("${microservice.order-service.endpoints.endpoint.uri:http://ORDER-SERVICE/order/bookOrder}")
    private String ENDPOINT_URL;
    private final UserRepository repository;
    private final RestTemplate template;
    public UserService(UserRepository repository, @Lazy RestTemplate template) {
        this.repository = repository;
        this.template = template;
    }

    public TransactionResponse createUser(TransactionRequest request) {
        User user = request.getUser();
        request.getOrder().setClientId(user.getUserId());
        // rest call to order service
        TransactionResponse response = template.postForObject(ENDPOINT_URL, request, TransactionResponse.class);
        repository.save(user);
        if (response != null) {
            response.setUser(user);
        }
        return response;
    }

}
