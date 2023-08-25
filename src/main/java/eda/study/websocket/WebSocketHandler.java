package eda.study.websocket;


import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler {
  
  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    String payload = message.getPayload();
    System.out.println("payload = " + payload);
    System.out.println("session = " + session);
    System.out.println("session = " + session.isOpen());

    if (message.getPayload().equals("안녕하세요")) {
      TextMessage textMessage = new TextMessage("오~~ 어서 오고");
      session.sendMessage(textMessage);
    } else if(message.getPayload().equals("이제 갈게")) {
      TextMessage textMessage = new TextMessage("어 그래 들어 가고~~");
      session.sendMessage(textMessage);
    }
  
  }
  // 클라이언트에서 연결을 시작할 경우 발생하는 이벤트
  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    super.afterConnectionEstablished(session);
    System.out.println("연결 시작~~~~~~~");
    LocalDateTime localDateTime = LocalDateTime.now();
    TextMessage textMessage = new TextMessage("안녕하세요 접속 시간은 " + localDateTime);
    session.sendMessage(textMessage);
  }
  
  // 클라이언트에서 연결을 종료할 경우 발생하는 이벤트
  @Override
  public void afterConnectionClosed(WebSocketSession session,
                                    CloseStatus status) throws Exception {
    super.afterConnectionClosed(session, status);
    System.out.println("연결 종료~~~~~~~~");
    
  }
  
}
