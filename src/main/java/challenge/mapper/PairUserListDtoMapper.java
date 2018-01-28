package challenge.mapper;

import challenge.dto.PairUserListDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PairUserListDtoMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        PairUserListDto pairUserListDto = new PairUserListDto();
        pairUserListDto.setUsername(rs.getString("USERNAME"));
        pairUserListDto.setMostPopulerFollowerId(rs.getLong("FOLLOWER_PERSON_ID"));

        return pairUserListDto;

    }
}
