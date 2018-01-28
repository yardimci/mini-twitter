package challenge.service;

import challenge.domain.User;
import challenge.dto.FollowingResponseDto;

public interface FollowService {

    FollowingResponseDto getFollowerList(User user);
    FollowingResponseDto getFollowingList(User user);
    FollowingResponseDto unfollowUser(User user, long unfollowUserId);
    FollowingResponseDto followUser(User user, long followUserId);

}
