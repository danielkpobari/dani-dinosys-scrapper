package com.dinosysassesment.dinosysdatascrapping.service;

import com.dinosysassesment.dinosysdatascrapping.dto.GitHubResponseDto;
import com.dinosysassesment.dinosysdatascrapping.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Service
@RequiredArgsConstructor
public class GitHubService implements ScrapeService {

    private final WebClient webClient;

    @Value("${github-base}")
    private String GITHUB_BASE_URL;

    @Value("${token}")
    private String GITHUB_TOKEN;

    @Override
    public Mono<ResponseEntity<List<ResponseDto>>> scrape() {
        List<ResponseDto>  responseList = new ArrayList<>();

        GitHubResponseDto[] response = webClient.get()
                .uri(getURI("/users"))
                .headers(httpHeaders -> httpHeaders.addAll(getHeaders()))
                .retrieve()
                .bodyToMono(GitHubResponseDto[].class).log().block();

        for (GitHubResponseDto res: response) {
            responseList.add(getAUserInfo(res.getUrl()));
        }

        return Mono.justOrEmpty(new ResponseEntity<>(responseList, OK));
    }


    private ResponseDto getAUserInfo(String userUrl) {
        return webClient.get()
                .uri(userUrl)
                .headers(httpHeaders -> httpHeaders.addAll(getHeaders()))
                .retrieve()
                .bodyToMono(ResponseDto.class).log().block();
    }


    private HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.valueOf("application/vnd.github+json"));
        httpHeaders.add("Authorization", "Bearer " + GITHUB_TOKEN);
        httpHeaders.add("X-GitHub-Api-Version", "2022-11-28");
        return httpHeaders;

    }

    private URI getURI(String url) {
        URI uri;
        try {
            uri = new URI(GITHUB_BASE_URL.concat(url));
        } catch (URISyntaxException exception) {
            throw new RuntimeException(exception);
        }
        return uri;
    }
}
