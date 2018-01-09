package com.lulech.controller;

import com.lulech.pojo.Students;
import com.lulech.service.impl.ClaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ClassController {
    @Autowired
    private ClaServiceImpl service;
    @RequestMapping("/teashowclass")
    String showClass(ModelMap map){
        map.addAttribute("oList", service.getSeleteList());
        return "classeslist";
    }
        
    @RequestMapping("forcvcourse")
    String forCVCourse(Students stu,ModelMap map){
        map.addAttribute("stu", stu);
        map.addAttribute("oList", service.getClassCourse());
        return "stucvcoushow";
    }
}
