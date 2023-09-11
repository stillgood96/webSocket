package eda.study.controller;

import eda.study.dto.ChatRoom;
import eda.study.service.ChatService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/chat")
public class ChatController {
  
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
}
