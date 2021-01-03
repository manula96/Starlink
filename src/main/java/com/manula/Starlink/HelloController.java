package com.manula.Starlink;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //have methods that map to url request
public class HelloController {
    @RequestMapping("/") //only take get requests
    public String SayHi(){
        return "Welcome Starlink Satelite Services";
    }
}
