package com.crystal2033.tacocloud.models;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @project TacoCloud
 * ©Crystal2033
 * @date 01/08/2023
 */

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;
    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(
                username, passwordEncoder.encode(password),
                fullname, street, city, state, zip, phone);
    }
}
