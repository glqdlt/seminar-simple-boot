package com.glqdlt.simple.ui.controller.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@RequestMapping("/auth")
@Controller
public class LoginController {

    @Value("${gateway.url}")
    private String apiGateUrl;

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model, HttpSession httpSession){
        model.addAttribute("apiUrl",apiGateUrl);
        return "/auth/login";
    }
}
