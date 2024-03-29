package eda.study.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import eda.study.dto.ChatRoom;
import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatService {
  /*
  * ChatRoomRepository가 대체 하기 때문에 사용하지 않음
  private final ObjectMapper objectMapper;
  private Map<String, ChatRoom> chatRooms;
  
  @PostConstruct
  private void init() {
    chatRooms = new LinkedHashMap<>();
  }
  
  public List<ChatRoom> findAllRoom() {
    return new ArrayList<>(chatRooms.values());
  }
  
  public ChatRoom findRoomById(String roomId) {
    return chatRooms.get(roomId);
  }
  
  public ChatRoom createRoom(String name) {
    String randomId = UUID.randomUUID().toString();
    ChatRoom chatRoom = ChatRoom.builder()
      .roomId(randomId)
      .name(name)
      .build();
    chatRooms.put(randomId, chatRoom);
    return chatRoom;
  }
  
  public <T> void sendMessage(WebSocketSession session, T message) {
    try {
      session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
    } catch (IOException e) {
      log.error(e.getMessage(), e);
    }
  }
  
   */
}
