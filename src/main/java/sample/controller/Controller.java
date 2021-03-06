package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import sample.dto.Receiver;
import sample.service.MessageService;
import sample.service.RoomService;

import java.util.List;
import java.util.Map;

@EnableWebMvc
@RestController
@RequestMapping("/")
class Controller {

    private final MessageService messageService;
    private final RoomService roomService;

    @Autowired
    public Controller(MessageService messageService, RoomService roomService) {
        this.messageService = messageService;
        this.roomService = roomService;
    }

    @PostMapping(value = "/salute")
    public String echo(@RequestParam(name = "name") String name,
                       @RequestParam(name = "hash") String hash) {

        return messageService.salute(name, hash);
    }

    @PostMapping(value = "/pleaseGeneral")
    public List<Receiver> getReceivedMessages() {
        return messageService.getReceivers();
    }

    @PostMapping(value = "/rooms")
    public Map<String, Integer> getRooms() {
        return roomService.getMessagesCountInAllRooms();
    }

}


