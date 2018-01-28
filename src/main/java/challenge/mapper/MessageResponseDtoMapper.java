package challenge.mapper;

import challenge.dto.MessageResponseDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageResponseDtoMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        MessageResponseDto messageResponseDto = new MessageResponseDto();
        messageResponseDto.setUsername(rs.getString("USERNAME"));
        messageResponseDto.setMessage(rs.getString("CONTENT"));

        return messageResponseDto;

    }

}
