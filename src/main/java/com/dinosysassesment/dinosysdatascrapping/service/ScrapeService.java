package com.dinosysassesment.dinosysdatascrapping.service;

import com.dinosysassesment.dinosysdatascrapping.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ScrapeService {

    Mono<ResponseEntity<List<ResponseDto>>> scrape();
}
