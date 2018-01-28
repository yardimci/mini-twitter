package challenge.controller;

import challenge.dto.MessageResponseDto;
import challenge.repository.impl.UserRepositoryImpl;
import challenge.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/user")
@RestController
public class MessageController {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private MessageService messageService;

    //for all messages
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public ResponseEntity<List<MessageResponseDto>> getMessageByUser() {
        return messageList(null);
    }

    @RequestMapping(value = "/message/{keyword}", method = RequestMethod.GET)
    public ResponseEntity<List<MessageResponseDto>> getMessageByUserAndKeyword(@PathVariable(value = "keyword") String keyword) {
        return  messageList(keyword);
    }

    public ResponseEntity messageList(String keyword){
        String username = getUsernameFromAuthentication();
        Long userId = userRepository.findByUsername(username).getId();
        List<MessageResponseDto> messageResponseDtoList =messageService.findMessageListByUser(userId, keyword);
        if(!messageResponseDtoList.isEmpty()){
            return new ResponseEntity<>(messageResponseDtoList, HttpStatus.OK);
        }
        if(messageResponseDtoList.isEmpty()){
            return new ResponseEntity<>("no related message with this user", HttpStatus.OK);
        }
        return new ResponseEntity<>("", HttpStatus.BAD_GATEWAY);
    }


    public String getUsernameFromAuthentication(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName(); //get logged in username
    }

}
