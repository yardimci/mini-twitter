package challenge.service;

import challenge.dto.MessageResponseDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void shouldReturnAllMessages() {
    List<MessageResponseDto> messageResponseDtoList = messageService.findMessageListByUser(1,null);

        Assert.assertNotNull(messageResponseDtoList);
        Assert.assertEquals(61, messageResponseDtoList.size());
    }

    @Test
    public void shouldReturnMessagesByKeyword(){
        List<MessageResponseDto> messageResponseDtoList = messageService.findMessageListByUser(1,"elit");

        Assert.assertNotNull(messageResponseDtoList);
        Assert.assertEquals(9, messageResponseDtoList.size());
    }

}
