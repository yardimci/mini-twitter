package challenge.repository.impl;

import challenge.constant.SqlQuery;
import challenge.dto.FollowerDto;
import challenge.mapper.FollowerMapper;
import challenge.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class FollowRepositoryImpl implements FollowRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<FollowerDto> findFollowersByUser(long userId) {
        return jdbcTemplate.query(SqlQuery.GET_FOLLOWERS_BY_USER, new Object[]{userId}, new FollowerMapper());
    }

    @Override
    public List<FollowerDto> findFollowingUserListByUser(long userId) {
        return jdbcTemplate.query(SqlQuery.GET_FOLLOWING_LIST_BY_USER, new Object[]{userId}, new FollowerMapper());
    }

    @Override
    public boolean unfollowUser(long userId, long unfollowedUserId) {
        return (jdbcTemplate.update(SqlQuery.UNFOLLOW_USER, new Object[]{unfollowedUserId, userId}) == 1);
    }

    @Override
    public boolean followUser(long userId, long followedUserId) {
        return (jdbcTemplate.update(SqlQuery.FOLLOW_USER, new Object[]{followedUserId, userId}) == 1);
    }
}
