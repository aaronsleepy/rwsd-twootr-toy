package com.socurites.twootr.domain;

import com.socurites.twootr.port.endpoint.ReceiverEndPoint;
import com.socurites.twootr.port.endpoint.SenderEndPoint;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Twootr {
    public Optional<SenderEndPoint> onLogon(String userId, String password, ReceiverEndPoint receiverEndPoint) {
        return Optional.of(new SenderEndPoint());
    }
}
