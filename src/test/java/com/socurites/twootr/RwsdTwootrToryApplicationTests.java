package com.socurites.twootr;

import com.socurites.twootr.domain.FollowStatus;
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
    private static final String OTHER_USER_ID = "John";
    private static final String PASSWORD = "ahc5ez";

    private final ReceiverEndPoint mockReceiverEndPoint = mock(ReceiverEndPoint.class);

    @Autowired
    private Twootr twootr;

    @Test
    public void shouldBeAbleToAuthenticateUser() {
        logon(USER_ID, PASSWORD);
    }

    private SenderEndPoint logon(final String userId, final String password) {
        final Optional<SenderEndPoint> senderEndPoint = this.twootr.onLogon(userId, password, mockReceiverEndPoint);
        assertThat(senderEndPoint.isPresent()).isTrue();

        return senderEndPoint.get();
    }

    @Test
    public void shouldNotAuthenticateUnknownUser() {
        final Optional<SenderEndPoint> senderEndPoint = this.twootr.onLogon("__No__User__", PASSWORD, mockReceiverEndPoint);

        assertThat(senderEndPoint.isEmpty()).isTrue();
    }

    @Test
    public void shouldNotAuthenticateWithWrongPassword() {
        final Optional<SenderEndPoint> senderEndPoint = this.twootr.onLogon(USER_ID, "wrong password", mockReceiverEndPoint);

        assertThat(senderEndPoint.isEmpty()).isTrue();
    }

    @Test
    public void shouldFollowValidUser() {
        final SenderEndPoint senderEndPoint = logon(USER_ID, PASSWORD);

        final FollowStatus followStatus = senderEndPoint.onFollow(OTHER_USER_ID);

        assertThat(followStatus).isEqualTo(FollowStatus.SUCCESS);
    }
}
