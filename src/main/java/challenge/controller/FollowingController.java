package challenge.controller;

import challenge.domain.User;
import challenge.dto.FollowingResponseDto;
import challenge.service.FollowService;
import challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/user")
@RestController
public class FollowingController {

    @Autowired
    private FollowService followService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/followers", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<FollowingResponseDto> getMessageByUser() {
        String username = getUsernameFromAuthentication();
        User user = userService.findByUsername(username);

        if (username == null) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
        // default donus happy path olmali
        return new ResponseEntity<>(followService.getFollowerList(user), HttpStatus.OK);
    }


    @RequestMapping(value = "/followingList", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<FollowingResponseDto> getFollowingList() {
        String username = getUsernameFromAuthentication();
        User user = userService.findByUsername(username);

        if (username != null) {
            return new ResponseEntity<>(followService.getFollowingList(user), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    @RequestMapping(value = "/unfollow/{unfollowUserId}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    ResponseEntity unfollowUser(@PathVariable long unfollowUserId) {
        String username = getUsernameFromAuthentication();
        User user = userService.findByUsername(username);
        // burda user null olamaz mi ?
        return new ResponseEntity<>(followService.unfollowUser(user, unfollowUserId), HttpStatus.OK);
    }

    @RequestMapping(value = "/follow/{followUserId}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    ResponseEntity followUser(@PathVariable long followUserId) {
        String username = getUsernameFromAuthentication();
        User user = userService.findByUsername(username);
        // burda user null olamaz mi ?
        return new ResponseEntity<>(followService.followUser(user, followUserId), HttpStatus.OK);
    }

    public String getUsernameFromAuthentication() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName(); //get logged in username
    }

}
