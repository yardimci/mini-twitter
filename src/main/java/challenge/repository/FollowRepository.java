package challenge.repository;

import challenge.dto.FollowerDto;

import java.util.List;

public interface FollowRepository {

    List<FollowerDto> findFollowersByUser(long userId);
    List<FollowerDto> findFollowingUserListByUser(long userId);
    boolean unfollowUser(long userId, long unfollowedUserId);
    boolean followUser(long userId, long followedUserId);

}
