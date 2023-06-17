package com.dinosysassesment.dinosysdatascrapping.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GitHubResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 2536462070880590662L;

    private String registered;
    private String name;
    private String avatar_url;
    private String username;
    private String email;
    private String url;
    private String company;
    private String blog;
    private String location;
    private String twitter_username;
    private String status;
    private String lastSeenStatus;
    private String upiId;
}
