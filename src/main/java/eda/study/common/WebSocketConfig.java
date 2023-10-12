package eda.study.common;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/*
@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {
  
  private final WebSocketHandler webSocketHandler;
  @Override
  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    registry.addHandler(webSocketHandler,"ws/chat").setAllowedOrigins("*");
    
  }
}

 */
@Configuration
@EnableWebSocketMessageBroker //websocket 서버를 사용 한다는 설정
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
  //WebSocket 클라이언트에서 간단한 메시징 프로토콜(예: STOMP)을 사용하여 메시지 처리를 구성하기 위한 방법
  
  //메시지 브로커 옵션을 구성
  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    // 구독주소. 주소를 구독한 클라이언트는 모든 브로드캐스팅 메세지를 수신
    config.enableSimpleBroker("/sub");
    // 송신주소. 클라이언트는 송신주소를 통해 메세지를 서버로 전송
    config.setApplicationDestinationPrefixes("/pub");
  }
  
  //각각을 특정 URL에 매핑하고 (선택적으로) SockJS 폴백 옵션을 활성화 및 구성하는 STOMP 엔드포인트를 등록
  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/ws-stomp") // 웹 소켓 생성 및 연결 값
            .setAllowedOriginPatterns("*")          // Cors 설정
            .withSockJS();  //               // 웹소켓을 지원하지 않는 브라우저도 연결 가능하도록
  }
}
