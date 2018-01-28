package challenge.service;

import challenge.dto.FollowingResponseDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FollowServiceTest {

    @Autowired
    private FollowService followService;

    @Test
    public void shouldReturnFollowersByUser() {
        FollowingResponseDto followingResponseDto = followService.getFollowerList(1, "batman");

        Assert.assertNotNull(followingResponseDto);
        Assert.assertEquals(6, followingResponseDto.getFollowerList().size());
        Assert.assertEquals("batman followers", followingResponseDto.getTitle());
    }

    @Test
    public void shouldReturnFollowingList() {
        FollowingResponseDto followingResponseDto = followService.getFollowingList(1, "batman");

        Assert.assertNotNull(followingResponseDto);
        Assert.assertEquals(5, followingResponseDto.getFollowerList().size());
        Assert.assertEquals("batman following list", followingResponseDto.getTitle());
    }


    @Test
    public void unfollowUserTest(){
        FollowingResponseDto followingResponseDto = followService.unfollowUser("batman",1,2);
        //user batman does not follow superman anymore
        Assert.assertNotNull(followingResponseDto);
        Assert.assertEquals(4, followingResponseDto.getFollowerList().size());
    }

    @Test
    public void followUserTest(){
        FollowingResponseDto followingResponseDto = followService.followUser("batman",1,2);
        //user batman does follow superman anymore
        Assert.assertNotNull(followingResponseDto);
        Assert.assertEquals(5, followingResponseDto.getFollowerList().size());
    }

}
