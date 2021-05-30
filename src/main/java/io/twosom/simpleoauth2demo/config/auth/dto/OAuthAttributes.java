package io.twosom.simpleoauth2demo.config.auth.dto;

import io.twosom.simpleoauth2demo.domain.user.Role;
import io.twosom.simpleoauth2demo.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class OAuthAttributes {

    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;


    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        return ofDiscord(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofDiscord(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes
                .builder()
                .name((String) attributes.get("username"))
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .role(Role.GUEST)
                .build();
    }

}
