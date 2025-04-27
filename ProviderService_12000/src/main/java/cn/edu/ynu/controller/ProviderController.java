package cn.edu.ynu.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/provider")
public class ProviderController {
    @GetMapping("/call")
    public String helloGet() {
        return "You called Service from port 12000, with GET method";
    }
}
