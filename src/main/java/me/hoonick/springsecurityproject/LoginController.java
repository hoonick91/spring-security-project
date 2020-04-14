package me.hoonick.springsecurityproject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {
    @RequestMapping("/")
    public String handleHome() {
        return "Public page";
    }

    @RequestMapping("/private")
    public String handlePrivate() {
        return "Private page";
    }

    @RequestMapping("/admin")
    public String handleAdmin() {
        return "Admin page";
    }

}
