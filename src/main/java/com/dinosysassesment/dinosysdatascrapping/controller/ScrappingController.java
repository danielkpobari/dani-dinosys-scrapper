package com.dinosysassesment.dinosysdatascrapping.controller;


import com.dinosysassesment.dinosysdatascrapping.dto.ResponseDto;
import com.dinosysassesment.dinosysdatascrapping.factory.ScrapeServiceFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ScrappingController {

    private final ScrapeServiceFactory factory;


    @GetMapping("/user")
    public Mono<List<ResponseDto>> getAnAuthenticatedUser(@RequestParam String platform) {
        return factory.processRequest(platform).mapNotNull(ResponseEntity::getBody);
    }

}
