package challenge.repository.impl;

import challenge.constant.SqlQuery;
import challenge.dto.MessageResponseDto;
import challenge.mapper.MessageResponseDtoMapper;
import challenge.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MessageRepositoryImpl implements MessageRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<MessageResponseDto> findAllMessagesByUserId(Long personId) {
        return jdbcTemplate.query(SqlQuery.GET_MESSAGES_BY_USER, new Object[] {personId}, new MessageResponseDtoMapper());
    }
}
