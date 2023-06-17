package com.dinosysassesment.dinosysdatascrapping.service;

import com.dinosysassesment.dinosysdatascrapping.dto.ResponseDto;
import com.dinosysassesment.dinosysdatascrapping.dto.TypicodeResponseDto;
import com.dinosysassesment.dinosysdatascrapping.exceptions.DinoSysScrappingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@Service
@RequiredArgsConstructor
public class TypicodeService implements ScrapeService {

    private final WebClient webClient;

    @Value("${typicode-base-url}")
    private String TYPICODE_BASE_URL;

    @Override
    public Mono<ResponseEntity<List<ResponseDto>>> scrape() {
        TypicodeResponseDto[] response = webClient.get()
                .uri(TYPICODE_BASE_URL.concat("/users"))
                .retrieve()
                .bodyToMono(TypicodeResponseDto[].class).log().block();

        if(response == null || response.length == 0) {
            throw new DinoSysScrappingException("Data could not be fetched. Please try again later.", INTERNAL_SERVER_ERROR);
        }

        List<ResponseDto> responseList =
                Arrays.asList(response).parallelStream().map(this::convert).collect(Collectors.toList());

        return Mono.justOrEmpty(new ResponseEntity<>(responseList, OK));
    }

    private ResponseDto convert(TypicodeResponseDto response) {
        return ResponseDto.builder()
                .location(response.getLocation())
                .blog(response.getWebsite())
                .company(response.getCompanyName())
                .name(response.getName())
                .username(response.getUsername())
                .email(response.getEmail()).build();
    }
}
