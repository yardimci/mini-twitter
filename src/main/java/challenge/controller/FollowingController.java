package challenge.controller;

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

    @RequestMapping(value = "/followers", method = RequestMethod.GET)
    public ResponseEntity<FollowingResponseDto> getMessageByUser() {
         String username = getUsernameFromAuthentication();
         long id = userService.findByUsername(username).getId();

        if(username!=null){
            return new ResponseEntity<>(followService.getFollowerList(id, username), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }



    @RequestMapping(value = "/followingList", method = RequestMethod.GET)
    public ResponseEntity<FollowingResponseDto> getFollowingList() {
         String username = getUsernameFromAuthentication();
         long id = userService.findByUsername(username).getId();

        if(username!=null){
            return new ResponseEntity<>(followService.getFollowingList(id, username), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    @RequestMapping(value = "/unfollow/{unfollowUserId}", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity unfollowUser(@PathVariable long unfollowUserId) {
         String username = getUsernameFromAuthentication();
        long id = userService.findByUsername(username).getId();
        return new ResponseEntity<>(followService.unfollowUser(username, id, unfollowUserId), HttpStatus.OK);
    }

    @RequestMapping(value = "/follow/{followUserId}", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity followUser(@PathVariable long followUserId) {
        String username = getUsernameFromAuthentication();
        long id = userService.findByUsername(username).getId();
        return new ResponseEntity<>(followService.followUser(username, id, followUserId), HttpStatus.OK);
    }

    public String getUsernameFromAuthentication() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName(); //get logged in username
    }

}
