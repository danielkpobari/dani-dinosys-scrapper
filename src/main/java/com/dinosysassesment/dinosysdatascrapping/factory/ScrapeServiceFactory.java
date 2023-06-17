package com.dinosysassesment.dinosysdatascrapping.factory;

import com.dinosysassesment.dinosysdatascrapping.dto.ResponseDto;
import com.dinosysassesment.dinosysdatascrapping.exceptions.DinoSysScrappingException;
import com.dinosysassesment.dinosysdatascrapping.service.GitHubService;
import com.dinosysassesment.dinosysdatascrapping.service.TypicodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.dinosysassesment.dinosysdatascrapping.exceptions.ErrorCode.INVALID_INPUT_PROVIDED;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@RequiredArgsConstructor
public class ScrapeServiceFactory {

    private final GitHubService gitHubService;
    private final TypicodeService typicodeService;

    public Mono<ResponseEntity<List<ResponseDto>>> processRequest(String platform) {
        if (platform == null || platform.trim().equals("")) {
            throw new DinoSysScrappingException(
                    "Invalid Platform. Please specify a valid platform", BAD_REQUEST, INVALID_INPUT_PROVIDED);
        }

        if (platform.equalsIgnoreCase("github")) {
            return gitHubService.scrape();
        } else if(platform.equalsIgnoreCase("typicode")) {
            return typicodeService.scrape();
        } else {
            throw new DinoSysScrappingException(
                    "Invalid Platform. Please specify a valid platform", BAD_REQUEST, INVALID_INPUT_PROVIDED);
        }
    }
}
