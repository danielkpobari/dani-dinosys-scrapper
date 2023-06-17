package com.dinosysassesment.dinosysdatascrapping.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TypicodeResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 8785920772156326035L;

    private String name;
    private String username;
    private String email;
    private Company company;
    private String website;
    private Address address;

    public String getLocation() {
        return this.address.getCity();
    }

    public String getCompanyName() {
        return this.company.getName();
    }
}


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = -3919272260807939302L;

    private String street;
    private String suite;
    private String city;
}

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Company implements Serializable {

    @Serial
    private static final long serialVersionUID = -5987764434913483751L;

    private String name;
}