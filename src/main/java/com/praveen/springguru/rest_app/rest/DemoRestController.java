package com.praveen.springguru.rest_app.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A REST controller class for handling test requests.
 * It provides an endpoint for saying hello.
 */
@RestController
@RequestMapping("/test")
public class DemoRestController {

    /**
     * Returns a string that represents a greeting message.
     * The message is "Hello World!".
     *
     * @return a string representing the greeting message
     */
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }
}
