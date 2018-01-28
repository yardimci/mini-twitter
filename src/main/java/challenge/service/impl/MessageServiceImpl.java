package challenge.service.impl;

import challenge.dto.MessageResponseDto;
import challenge.repository.MessageRepository;
import challenge.repository.impl.UserRepositoryImpl;
import challenge.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepositoryImpl userRepository;

    @Override
    public List<MessageResponseDto> findMessageListByUser(long id, String keyword) {
        List<MessageResponseDto> messageResponseDtoList= messageRepository.findAllMessagesByUserId(id);
        List<MessageResponseDto> messageResponseReturnList = new ArrayList<>();
        for(MessageResponseDto messageResponseDto : messageResponseDtoList){
            if (keyword!=null){
                if(Pattern.compile(Pattern.quote(keyword), Pattern.CASE_INSENSITIVE).matcher(messageResponseDto.getMessage()).find()){
                    messageResponseReturnList.add(messageResponseDto);
                }
            }else {
                messageResponseReturnList.add(messageResponseDto);
            }
        }
        return messageResponseReturnList;
    }
}
