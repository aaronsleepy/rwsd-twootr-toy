package com.socurites.twootr.port.endpoint;

import com.socurites.twootr.domain.FollowStatus;
import com.socurites.twootr.domain.Twootr;
import com.socurites.twootr.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class SenderEndPoint {
    private final User user;
    private final Twootr twootr;

    public FollowStatus onFollow(final String userIdToFollow) {
        Objects.requireNonNull(userIdToFollow);

        return this.twootr.onFollow(this.user, userIdToFollow);
    }
}
