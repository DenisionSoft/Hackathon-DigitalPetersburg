package spb.hack.lifeindex.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spb.hack.lifeindex.model.Index;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/index")
@AllArgsConstructor
@RequiredArgsConstructor
public class IndexController {
    private final IndexService indexService;

    @PostMapping
    public ResponseEntity<ArrayList<Index>> getIndex(@RequestBody GetIndexRequest request) {
        return indexService.getIndex(request);
    }
}
