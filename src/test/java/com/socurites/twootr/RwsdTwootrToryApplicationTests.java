package com.socurites.twootr;

import com.socurites.twootr.domain.Twootr;
import com.socurites.twootr.port.endpoint.ReceiverEndPoint;
import com.socurites.twootr.port.endpoint.SenderEndPoint;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class RwsdTwootrToryApplicationTests {
    private static final String USER_ID = "Joe";
    private static final String PASSWORD = "ahc5ez";

    private final ReceiverEndPoint mockReceiverEndPoint = mock(ReceiverEndPoint.class);

    @Autowired
    private Twootr twootr;

    @Test
    public void shouldBeAbleToAuthenticateUser() {
        final Optional<SenderEndPoint> senderEndPoint = this.twootr.onLogon(USER_ID, PASSWORD, mockReceiverEndPoint);

        assertThat(senderEndPoint.isPresent()).isTrue();
    }

    @Test
    public void shouldNotAuthenticateWithWrongPassword() {
        final Optional<SenderEndPoint> senderEndPoint = this.twootr.onLogon(USER_ID, "wrong password", mockReceiverEndPoint);

        assertThat(senderEndPoint.isEmpty()).isTrue();
    }
}
