package com.socurites.twootr.domain;

import com.socurites.twootr.port.endpoint.ReceiverEndPoint;
import com.socurites.twootr.port.endpoint.SenderEndPoint;
import org.springframework.stereotype.Service;

@Service
public class Twootr {
    public SenderEndPoint onLogon(String userId, ReceiverEndPoint receiverEndPoint) {
        return new SenderEndPoint();
    }
}
