package challenge.repository.impl;

import challenge.constant.SqlQuery;
import challenge.domain.User;
import challenge.dto.PairUserListDto;
import challenge.mapper.FollowerMapper;
import challenge.mapper.PairUserListDtoMapper;
import challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<PairUserListDto> pairUserListDtoList() {
        return jdbcTemplate.query(SqlQuery.MOST_POPULER_PAIR_LIST, new PairUserListDtoMapper());
    }
}
