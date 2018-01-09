package com.lulech.controller;

import com.lulech.pojo.Classes;
import com.lulech.pojo.CurriculaVariable;
import com.lulech.pojo.Students;
import com.lulech.service.impl.CouServiceImpl;
import com.lulech.service.impl.CurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CurriculaVariableController {
    @Autowired
    CurServiceImpl service;
    @Autowired
    CouServiceImpl cousevice;
    
    @RequestMapping("cvcourses")
    String doCVCourse(Students stu,Classes classes,ModelMap map){
        String h="CV0000000"+(service.getSeleteList().size()+1);
        CurriculaVariable cv = new CurriculaVariable(h, classes, stu);
        service.doSave(cv);
        map.addAttribute("stu", stu);
        map.addAttribute("oList",cousevice.getCourseByStuId(stu.getStuId()));
        return "stushowcourse";
    }
}
