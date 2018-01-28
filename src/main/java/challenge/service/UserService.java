package challenge.service;

import challenge.domain.User;

import java.util.Map;

public interface UserService {

    User findByUsername(String username);
    User findById(long id);
    Map<String , String> userListWithMostPopulerPair();

}
