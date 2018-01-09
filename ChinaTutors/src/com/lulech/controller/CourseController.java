package com.lulech.controller;

import com.lulech.pojo.Courses;
import com.lulech.pojo.Students;
import com.lulech.service.impl.CouServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CourseController{
    @Autowired
    private CouServiceImpl service;
    @RequestMapping(value="addcourse")
    String doAdd(Courses cou,ModelMap map){
        service.doSave(cou);
        map.addAttribute("oList",service.getSeleteList());
        return "courselist";
    }
    @RequestMapping(value="updatecourse")
    String doUpdate(Courses cou,ModelMap map){
        service.doUpdate(cou);
        map.addAttribute("oList",service.getSeleteList());
        return "courselist";
    }
    @RequestMapping(value="deletecourse")
    String doDelete(String courseId,ModelMap map){
        service.doDelete(courseId);
        map.addAttribute("oList",service.getSeleteList());
        return "courselist";
    }
    @RequestMapping(value="showcourse")
    String showCourses(ModelMap map){
        map.addAttribute("oList",service.getSeleteList());
        return "courselist";
    }
    
    @RequestMapping(value="forupdatecourse")
    String forUpdate(String courseId,ModelMap map){
        map.addAttribute("c", service.getSelete(courseId));
        return "courseupdate";
    }
   
    @RequestMapping(value="foraddcourse")
    String forAdd(String courseId,ModelMap map){
        return "courseadd";
    }
    
    @RequestMapping(value="stushowcourse")
    String stuShowCourse(Students stu,ModelMap map){
        map.addAttribute("stu",stu);
        map.addAttribute("oList", service.getCourseByStuId(stu.getStuId()));
        return "stushowcourse";
    }

}
