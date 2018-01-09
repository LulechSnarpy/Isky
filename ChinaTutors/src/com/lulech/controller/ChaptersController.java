package com.lulech.controller;

import com.lulech.pojo.Chapters;
import com.lulech.pojo.Courses;
import com.lulech.pojo.Students;
import com.lulech.service.impl.ChapServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ChaptersController {

    @Autowired
    private ChapServiceImpl service;

    @RequestMapping(value = "/showAllChapters")
    public String showAllChapters(Courses course,ModelMap map) {
        map.addAttribute("course", course);
        if(course!=null){
             map.addAttribute("oList", service.getChapterByCourse(course));
        }else{
            map.addAttribute("oList", service.getSeleteList());
        }
        return "coursedetail";
    }
    
    @RequestMapping(value="/addchapers")
    public String addChapters(Chapters chapter,Courses course,ModelMap map){
        chapter.setCourses(course);
        service.doSave(chapter);
        map.addAttribute("course",course);
        map.addAttribute("oList", service.getChapterByCourse(course));
        return "coursedetail";
    }
    
    @RequestMapping(value = "/updatechapters")
    public String updateChapters(Chapters chapter,Courses course,ModelMap map){
        chapter.setCourses(course);
        service.doUpdate(chapter);
        map.addAttribute("course", course);
        map.addAttribute("oList", service.getChapterByCourse(course));
        return "coursedetail";
    }
    
    @RequestMapping(value = "/deletechapters")
    public String deleteChapters(String chapterId,Courses course,ModelMap map){
        service.doDelete(chapterId);
        map.addAttribute("course", course);
        map.addAttribute("oList", service.getChapterByCourse(course));
        return "coursedetail";
    }
    
    @RequestMapping(value="/showchapterdetail")
    public String showChapter(String chapterId,Courses course,ModelMap map){
        map.addAttribute("course", course);
        map.addAttribute("c", service.getSelete(chapterId));
        return "chapterdetail";
    }
    
    @RequestMapping(value = "/foraddchapters")
    public String forAddChapters(Courses course,ModelMap map){
        map.addAttribute("course", course);
        return "chapteradd";
    }
    
    @RequestMapping(value ="/forupdatechapters")
    public String forUpdateChapters(String chapterId,Courses course,ModelMap map){
        map.addAttribute("c",service.getSelete(chapterId));
        map.addAttribute("course", course);
        return "chapterupdate";
    }
    
    @RequestMapping(value="/stushowchapter")
    String stuShowChapter(Courses course,Students stu,ModelMap map){
        map.addAttribute("course", course);
        map.addAttribute("stu", stu);
        map.addAttribute("oList", service.getChapterByCourse(course));
        return "stuchapter";
    }
    
    @RequestMapping(value="/stushowchapterdetail")
    String stuShowChapterDetail(Courses course,Students stu,Chapters chapter,ModelMap map){
        map.addAttribute("course", course);
        map.addAttribute("stu", stu);
        map.addAttribute("c", service.getSelete(chapter.getChapterId()));
        return "stuchapterdetail";
    }
}
