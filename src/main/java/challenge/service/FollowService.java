package challenge.service;

import challenge.dto.FollowingResponseDto;

public interface FollowService {

    FollowingResponseDto getFollowerList(long userId, String username);
    FollowingResponseDto getFollowingList(long userId, String username);
    FollowingResponseDto unfollowUser(String username, long userId, long unfollowUserId);
    FollowingResponseDto followUser(String username, long userId, long followUserId);

}
