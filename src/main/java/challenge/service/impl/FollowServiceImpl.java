package challenge.service.impl;

import challenge.dto.FollowerDto;
import challenge.dto.FollowingResponseDto;
import challenge.repository.FollowRepository;
import challenge.repository.UserRepository;
import challenge.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public FollowingResponseDto getFollowerList(long userId, String username) {
        return createUserList(true, userId, username);
    }

    @Override
    public FollowingResponseDto getFollowingList(long userId, String username) {
        return createUserList(false, userId, username);
    }

    @Override
    public FollowingResponseDto unfollowUser(String username, long userId, long unfollowUserId) {
        if (followRepository.unfollowUser(userId, unfollowUserId)) {
            return getFollowingList(userId, username);
        }
        return getFollowerList(userId, username);
    }

    @Override
    public FollowingResponseDto followUser(String username, long userId, long followUserId) {
        if (followRepository.followUser(userId, followUserId)) {
            return getFollowingList(userId, username);
        }
        return getFollowerList(userId, username);
    }

    private FollowingResponseDto createUserList(boolean isFollowerList, long userId, String username) {
        FollowingResponseDto followingResponseDto = new FollowingResponseDto();
        List<FollowerDto> followerDtoList;
        if (isFollowerList) {
            followerDtoList = followRepository.findFollowersByUser(userId);
            followingResponseDto.setTitle(username + " followers");
        } else {
            followerDtoList = followRepository.findFollowingUserListByUser(userId);
            followingResponseDto.setTitle(username + " following list");
        }
        followingResponseDto.setFollowerList(followerDtoList);
        return followingResponseDto;
    }
}
