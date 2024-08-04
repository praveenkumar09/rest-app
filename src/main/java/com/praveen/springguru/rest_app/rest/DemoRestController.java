package com.praveen.springguru.rest_app.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    /**
     * GET MAPPING
     * add code for the "/hello" endpoint
     * @Returns : String "Hello World"
     */
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }
}
