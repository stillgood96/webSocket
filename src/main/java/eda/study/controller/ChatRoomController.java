package eda.study.controller;

import eda.study.dto.ChatRoom;
import eda.study.repository.ChatRoomRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatRoomController {
  
  private final ChatRoomRepository chatRoomRepository;
  
  
  
  // 채팅 리스트 화면
  @GetMapping("/room")
  public ModelAndView rooms(Model model) {
    System.out.println(" 통신은 된다1");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("room");
    return mav;
  }
  
  // 모든 채팅방 목록
  @GetMapping("/rooms")
  @ResponseBody
  public List<ChatRoom> room() {
    return chatRoomRepository.findAllRoom();
  }
  
  // 채팅방 생성
  @PostMapping("/room")
  @ResponseBody
  public ChatRoom createRoom(@RequestParam String name) {
    return chatRoomRepository.createChatRoom(name);
  }
  
  // 채팅방 입장 화면
  @GetMapping("/room/enter/{roomId}")
  public ModelAndView roomDetail(Model model, @PathVariable String roomId) {
//    model.addAttribute("roomId", roomId);
    System.out.println(" 통신은 된다2");
    
    ModelAndView mav = new ModelAndView();
    mav.addObject("room", model);
    mav.addObject("roomId", roomId);
    mav.setViewName("roomdetail");
    
    return mav;
  }
  
  // 특정 채팅방 조회
  @GetMapping("/room/{roomId}")
  @ResponseBody
  public ChatRoom roomInfo(@PathVariable String roomId) {
    return chatRoomRepository.findRoomById(roomId);
  }
}
