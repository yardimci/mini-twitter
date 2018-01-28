package challenge.repository.impl;

import challenge.constant.SqlQuery;
import challenge.domain.User;
import challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public User findByUsername(String username) {
        return jdbcTemplate.queryForObject(SqlQuery.GET_USER_BY_USERNAME, new Object[] {username},
                new BeanPropertyRowMapper< User >(User.class));
    }

    public User findById(long id) {
        return jdbcTemplate.queryForObject(SqlQuery.GET_USER_BY_ID, new Object[] {id},
                new BeanPropertyRowMapper< User >(User.class));
    }
}
