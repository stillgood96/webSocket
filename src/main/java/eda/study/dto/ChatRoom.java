package eda.study.dto;

import eda.study.service.ChatService;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

@Getter
public class ChatRoom {
  
  private String roomId;
  private String name;
  
  
  public static ChatRoom create(String name) {
    ChatRoom chatRoom = new ChatRoom();
    chatRoom.roomId = UUID.randomUUID().toString();
    chatRoom.name = name;
    return chatRoom;
  }
  
  
  /*
  pub/sub 방식을 이용하여 구독자 관리가 알아서 되므로 웹소켓 세션 관리가 필요 없어짐
  private Set<WebSocketSession> sessions = new HashSet<>();
  
  
  @Builder
  public ChatRoom(String roomId, String name) {
    this.roomId = roomId;
    this.name = name;
  }
  
  public void handleActions(WebSocketSession session, ChatMessage chatMessage, ChatService chatService) {
    if(chatMessage.getType().equals(ChatMessage.MessageType.ENTER)) {
      sessions.add(session);
      chatMessage.setMessage(chatMessage.getSender() + "님이 입장했습니다");
    }
    sendMessage(chatMessage, chatService);
  }
  
  public <T> void sendMessage(T message, ChatService chatService) {
    sessions.parallelStream().forEach(sessions -> chatService.sendMessage(sessions, message));
  }
  
   */
}
