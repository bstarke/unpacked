package net.starkenberg.junk.unpacked;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Provider;
import java.security.Security;
import java.util.Arrays;

@SpringBootApplication
@RestController
public class UnpackedApplication {

    public static void main(String[] args) {
        Arrays.stream(Security.getProviders()).map(Provider::getName).forEach(System.out::println);
        SpringApplication.run(UnpackedApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
