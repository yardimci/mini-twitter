package challenge.mapper;

import challenge.dto.FollowerDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FollowerMapper  implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        FollowerDto followerDto = new FollowerDto();
        followerDto.setUsername(rs.getString("USERNAME"));
        followerDto.setName(rs.getString("NAME"));

        return followerDto;

    }

}
