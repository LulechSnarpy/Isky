package com.lulech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class IndexController {
    @RequestMapping(value="/login")
    String toLogin(){
        return "login";
    }
}
