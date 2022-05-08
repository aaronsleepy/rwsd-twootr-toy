package com.socurites.twootr.domain;

import com.socurites.twootr.port.endpoint.ReceiverEndPoint;
import com.socurites.twootr.port.endpoint.SenderEndPoint;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class Twootr {
    private static Map<String, User> authenticatedUsers;

    @PostConstruct
    public void init() {
        this.authenticatedUsers = new HashMap<>();
        this.authenticatedUsers.put("Joe", User.builder().id("Joe")
                .password("ahc5ez")
                .build());
    }

    public Optional<SenderEndPoint> onLogon(String userId, String password, ReceiverEndPoint receiverEndPoint) {
        Objects.requireNonNull(userId, "userId");
        Objects.requireNonNull(password, "password");

        final User authenticatedUser = authenticatedUsers.get(userId);
        if (null != authenticatedUser && authenticatedUser.getPassword().equals(password)) {
            return Optional.of(new SenderEndPoint());
        }
        return Optional.empty();
    }
}
