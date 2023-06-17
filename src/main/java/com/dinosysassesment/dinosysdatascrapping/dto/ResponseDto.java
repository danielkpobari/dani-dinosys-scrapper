package com.dinosysassesment.dinosysdatascrapping.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 2536462070880590662L;

    private String name;
    private String avatar_url;
    private String username;
    private String email;
    private String company;
    private String blog;
    private String location;

}
