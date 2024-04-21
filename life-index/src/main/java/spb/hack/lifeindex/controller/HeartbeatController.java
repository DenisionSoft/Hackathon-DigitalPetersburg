package spb.hack.lifeindex.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ping")
@RequiredArgsConstructor
public class HeartbeatController {
    @RequestMapping
    public String ping() {
        return "pong2";
    }
}
