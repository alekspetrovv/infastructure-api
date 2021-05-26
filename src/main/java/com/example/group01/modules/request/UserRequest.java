package com.example.group01.modules.request;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String role;

}
