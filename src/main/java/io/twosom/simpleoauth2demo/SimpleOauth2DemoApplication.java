package io.twosom.simpleoauth2demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
public class SimpleOauth2DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleOauth2DemoApplication.class, args);
    }


    @GetMapping("/")
    public String hello() {
        return "Hello Discord";
    }

    @GetMapping("/user")
    public Principal principal(Principal principal) {

        return principal;
    }
}
