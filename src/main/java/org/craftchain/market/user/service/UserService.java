package org.craftchain.market.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.craftchain.market.user.common.TransactionRequest;
import org.craftchain.market.user.common.TransactionResponse;
import org.craftchain.market.user.entity.User;
import org.craftchain.market.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger log = LoggerFactory.getLogger(UserService.class);
    public UserService(UserRepository repository, @Lazy RestTemplate template) {
        this.repository = repository;
        this.template = template;
    }

    public TransactionResponse createUser(TransactionRequest request) throws JsonProcessingException {
        User user = request.getUser();
        request.getOrder().setClientId(user.getUserId());
        log.info("UserService request: {}", new ObjectMapper().writeValueAsString(request));
        // rest call to order service
        TransactionResponse response = template.postForObject(ENDPOINT_URL, request, TransactionResponse.class);
        log.info("UserService : transaction response from OrderService rest template call: {}", new ObjectMapper().writeValueAsString(request));
        repository.save(user);
        if (response != null) {
            response.setUser(user);
        }
        return response;
    }

}
