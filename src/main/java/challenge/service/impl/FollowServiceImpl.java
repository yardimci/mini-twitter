package challenge.service.impl;

import challenge.domain.User;
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
    public FollowingResponseDto getFollowerList(User user) {
        return createUserList(true, user);
    }

    @Override
    public FollowingResponseDto getFollowingList(User user) {
        return createUserList(false, user);
    }

    @Override
    public FollowingResponseDto unfollowUser(User user, long unfollowUserId) {
        if (followRepository.unfollowUser(user.getId(), unfollowUserId)) {
            return getFollowingList(user);
        }
        return getFollowerList(user);
    }

    @Override
    public FollowingResponseDto followUser(User user, long followUserId) {
        if (followRepository.followUser(user.getId(), followUserId)) {
            return getFollowingList(user);
        }
        return getFollowerList(user);
    }

    private int shortestWay(long userId, long otherUserId){
        boolean findUser=false;

        while (!findUser){

        }


        return 0;
    }


    private FollowingResponseDto createUserList(boolean isFollowerList, User user) {
        FollowingResponseDto followingResponseDto = new FollowingResponseDto();
        List<FollowerDto> followerDtoList;
        if (isFollowerList) {
            followerDtoList = followRepository.findFollowersByUser(user.getId());
            followingResponseDto.setTitle(user.getUsername() + " followers");
        } else {
            followerDtoList = followRepository.findFollowingUserListByUser(user.getId());
            followingResponseDto.setTitle(user.getUsername() + " following list");
        }
        followingResponseDto.setFollowerList(followerDtoList);
        return followingResponseDto;
    }
}
