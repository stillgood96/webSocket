package eda.study.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
  
  public enum MessageType {
    ENTER, TALK, JOIN
  }
  
  private MessageType type; // 메세지 타입
  private String roomId;    // 방번호
  private String sender;    // 보낸 사람
  private String message;   // 메시지
}
