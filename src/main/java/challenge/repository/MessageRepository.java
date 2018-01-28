package challenge.repository;

import challenge.dto.MessageResponseDto;

import java.util.List;

public interface MessageRepository {

    List<MessageResponseDto> findAllMessagesByUserId(Long userId);

}
