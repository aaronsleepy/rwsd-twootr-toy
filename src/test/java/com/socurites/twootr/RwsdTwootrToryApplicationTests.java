package com.socurites.twootr;

import com.socurites.twootr.domain.Twootr;
import com.socurites.twootr.port.endpoint.SenderEndPoint;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class RwsdTwootrToryApplicationTests {
    @Autowired
    private Twootr twootr;

    @Test
    public void shouldBeAbleToAuthenticateUser() {
        final SenderEndPoint senderEndPoint = this.twootr.onLogon(null, null);
    }
}
