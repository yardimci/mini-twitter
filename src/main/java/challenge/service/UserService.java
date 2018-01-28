package challenge.service;

import challenge.domain.User;

public interface UserService {

    User findByUsername(String username);
    User findById(long id);

}
