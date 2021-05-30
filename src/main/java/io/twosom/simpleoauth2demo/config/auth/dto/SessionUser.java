package io.twosom.simpleoauth2demo.config.auth.dto;

import io.twosom.simpleoauth2demo.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }


}
