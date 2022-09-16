package com.amine.sbjwfvs;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService streamingService;

    @GetMapping(value="/video/{title}", produces = "video/mp4")
    public Mono<Resource> getStream(@PathVariable("title") String title, @RequestHeader("range") String range) {
        System.out.println("range in bytes() : " + range);
        return streamingService.getVideo(title);
    }
}
