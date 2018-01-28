package challenge.service;

import challenge.dto.MessageResponseDto;

import java.util.List;

public interface MessageService {

    List<MessageResponseDto> findMessageListByUser(long id, String keyword);

}
