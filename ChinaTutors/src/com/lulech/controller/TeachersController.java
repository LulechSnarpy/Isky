package com.lulech.controller;

import com.lulech.pojo.Teachers;
import com.lulech.service.impl.TeaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class TeachersController {
    @Autowired
    private TeaServiceImpl service;
    @RequestMapping(value="/tealogin")
    String teaLogin(Teachers tea,ModelMap map){
        Teachers teac = service.getSelete(tea.getTeaId());
        if(null!=teac&&tea.getTpassword().equals(teac.getTpassword())){
            map.addAttribute("tea", tea);
            return "teaindex";
        }
        return "register";
    }
    
    @RequestMapping(value="/forteaIndex")
    String forTeaIndex(Teachers tea,ModelMap map){
        map.addAttribute("tea", tea);
        return "teaindex";
    }
}
