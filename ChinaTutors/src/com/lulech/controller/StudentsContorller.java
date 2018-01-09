package com.lulech.controller;

import com.lulech.pojo.Students;
import com.lulech.service.impl.StuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class StudentsContorller {
    @Autowired
    StuServiceImpl service;
    
    @RequestMapping(value="/stulogin")
    String stuLogin(Students stu,ModelMap map){
        Students stuc = service.getSelete(stu.getStuId());
        if(null!=stuc&&stu.getSpassword().equals(stuc.getSpassword())){
            map.addAttribute("stu", stu);
            return "stuindex";
        }
        return "register";
    }
    @RequestMapping(value="/register")
    String stuRegester(Students stu,ModelMap map){
       Students stuc = service.getSelete(stu.getStuId());
       if(null!=stuc) return "register";
       service.doSave(stu);
       return "login";
    }
//    @RequestMapping(value = "/score")
//    String stuShowScore(Students stu,ModelMap map){
//        map.addAttribute("stu", stu);
//        return "";
//    }
//    
//    @RequestMapping(value="/")
//    String showExams(Students stu,ModelMap map){
//        map.addAttribute("stu", stu);
//        return "";
//    }
//    
//    @RequestMapping(value="/")
//    String stuTackExam(Students stu,ModelMap map){
//        map.addAttribute("stu", stu);
//        return "";
//    }
     @RequestMapping(value="/forstuIndex")
    String forTeaIndex(Students stu,ModelMap map){
        map.addAttribute("stu", stu);
        return "stuindex";
    }
}
