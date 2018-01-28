package challenge.controller;

import challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userListWithMostPopulerPair", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> userListWithMostPopulerPair() {
        return new ResponseEntity<>(userService.userListWithMostPopulerPair(), HttpStatus.OK);
    }

}
