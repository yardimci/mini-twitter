package challenge.repository;

import challenge.domain.User;

public interface UserRepository {
    User findByUsername(String username);
    User findById(long id);
}
