package eda.study.websocket;

import eda.study.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@RequiredArgsConstructor
@Configuration
@ComponentScan(basePackages = "eda.study.service")
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
  private final WebSocketHandler webSocketHandler;
  @Override
  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    registry.addHandler(webSocketHandler,"ws/chat").setAllowedOrigins("*");
    
  }
}
