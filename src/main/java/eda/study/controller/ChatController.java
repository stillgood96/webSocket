package eda.study.controller;

import eda.study.dto.ChatMessage;
import eda.study.dto.ChatRoom;
import eda.study.service.ChatService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/chat")
public class ChatController {
  
  private final SimpMessageSendingOperations messagingTemplate;
  
  
  @MessageMapping("/message")
  public void message(ChatMessage message) {
    
    if(ChatMessage.MessageType.ENTER.equals(message.getType())) {
      message.setMessage(message.getSender() + "님이 입장하셨습니다.");
    }
    
    System.out.println("통신이 된다3");
    // 전달 받은 메세지를 브로드캐스트 방식으로 구독 중인 클라이언트들에게 뿌릴
    messagingTemplate.convertAndSend("/sub/chat/room" + message.getRoomId(), message);
  }
  
  
 /*
  private final ChatService chatService;
  
  
  @PostMapping
  @ResponseBody
  public ChatRoom createRoom(@RequestBody String name) {
    return chatService.createRoom(name);
  }
  
  @GetMapping
  @ResponseBody
  public List<ChatRoom> findAllRoom() {
    return chatService.findAllRoom();
  }
  
  */
}
