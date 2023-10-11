package eda.study.common;


import com.fasterxml.jackson.databind.ObjectMapper;
import eda.study.dto.ChatMessage;
import eda.study.dto.ChatRoom;
import eda.study.service.ChatService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
@Slf4j
@RequiredArgsConstructor
@Component
public class WebSocketChatHandler extends TextWebSocketHandler {
  private final ObjectMapper objectMapper;
  private final ChatService chatService;
  
  //webSocketSession을 담아두는 Map
//  private final Set<WebSocketSession> buckets = ConcurrentHashMap.newKeySet();
  /*
  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    String payload = message.getPayload();
    log.info("payload {}", payload);
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("payload", payload);
    System.out.println("jsonObject.toJSONString() = " + jsonObject.toJSONString());

    if (message.getPayload().equals("안녕하세요")) {
      TextMessage textMessage = new TextMessage("오~~ 어서 오고");
      session.sendMessage(textMessage);
    } else if(message.getPayload().equals("이제 갈게")) {
      TextMessage textMessage = new TextMessage("어 그래 들어 가고~~");
      session.sendMessage(textMessage);
    }

    System.out.println("payload = " + payload);
    System.out.println("session = " + session);
    System.out.println("session = " + session.isOpen());
    ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
    ChatRoom room = chatService.findRoomById(chatMessage.getRoomId());
    room.handleActions(session, chatMessage, chatService);
  }
  // 클라이언트에서 연결을 시작할 경우 발생하는 이벤트
  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    super.afterConnectionEstablished(session);
    
    System.out.println("연결 시작~~~~~~~");
    System.out.println(" = 연결세션은  " + session );
    
//    buckets.add(session);
//    System.out.println("buckets.size= " + buckets.size());
    
    LocalDateTime localDateTime = LocalDateTime.now();
//    TextMessage textMessage = new TextMessage("안녕하세요 접속 시간은 " + localDateTime);
//    session.sendMessage(textMessage);
  }
  
  // 클라이언트에서 연결을 종료할 경우 발생하는 이벤트
  @Override
  public void afterConnectionClosed(WebSocketSession session,
                                    CloseStatus status) throws Exception {
    super.afterConnectionClosed(session, status);
    LocalDateTime localDateTime = LocalDateTime.now();
    
    System.out.println("연결 종료~~~~~~~~ 종료시간은 : " + localDateTime );
    System.out.println(" = 종료세션은  " + session );
    
//    buckets.remove(session);
  
  }
  
  // 클라이언트로부터 메세지가 도착하면 실행된다.
  @Override
  public void handleMessage(WebSocketSession session, WebSocketMessage<?> message)
    throws Exception {
    super.handleMessage(session, message);

    System.out.println("방금 메세지를 보낸 session = " + session);
  }
  
   */
}
