package eda.study.websocket;


import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler {
  
  private final Set<WebSocketSession> buckets = ConcurrentHashMap.newKeySet();
  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    String payload = message.getPayload();
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
  }
  // 클라이언트에서 연결을 시작할 경우 발생하는 이벤트
  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    super.afterConnectionEstablished(session);
    System.out.println("연결 시작~~~~~~~");
    System.out.println(" = 연결세션은  " + session );
    buckets.add(session);
    System.out.println("buckets.size= " + buckets.size());
    System.out.println("buckets = " + buckets.toString());
    LocalDateTime localDateTime = LocalDateTime.now();
    TextMessage textMessage = new TextMessage("안녕하세요 접속 시간은 " + localDateTime);
    session.sendMessage(textMessage);
  }
  
  // 클라이언트에서 연결을 종료할 경우 발생하는 이벤트
  @Override
  public void afterConnectionClosed(WebSocketSession session,
                                    CloseStatus status) throws Exception {
    super.afterConnectionClosed(session, status);
    LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println("연결 종료~~~~~~~~ 종료시간은 : " + localDateTime );
    System.out.println(" = 종료세션은  " + session );
    buckets.remove(session);
    
  }
  
  // - 클라이언트로부터 메세지가 도착하면 실행된다.
  @Override
  public void handleMessage(WebSocketSession session, WebSocketMessage<?> message)
    throws Exception {
    super.handleMessage(session, message);
  }
}
