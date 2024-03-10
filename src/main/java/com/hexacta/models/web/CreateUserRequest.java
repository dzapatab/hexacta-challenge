package com.hexacta.models.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {

    private String name;
    private String lastName;
    private String email;
    private String company;
    private String yourMessage;
    private String job;
}
