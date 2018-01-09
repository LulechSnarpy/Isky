package com.lulech.controller;

import com.lulech.entity.ExamFile;
import com.lulech.pojo.Chapters;
import com.lulech.pojo.Courses;
import com.lulech.pojo.Exams;
import com.lulech.pojo.Students;
import com.lulech.service.impl.ExamsServiceImpl;
import com.lulech.service.impl.FileIOServiceImpl;
import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping
public class ExamController {
    @Autowired
    private ExamsServiceImpl service;
    @Autowired
    private FileIOServiceImpl fileservice;
    @RequestMapping(value="/forexamadd")
    String forExamAdd(ModelMap map){
        return "examadd";
    }
    @RequestMapping(value="/examadd")
    String examAdd(Exams e,Chapters c,ModelMap map,HttpServletRequest request){
        e.setChapters(c);
        service.doSave(e);
        map.addAttribute("o", e);
        request.getSession().setAttribute("o", e);
        return "examaddsc";
    }
    @RequestMapping(value="/examaddsc")
    String examAddSc(ModelMap map,HttpServletRequest request,MultipartFile examfile) throws IOException{
        Exams e = (Exams) request.getSession().getAttribute("o");
        HttpSession session = request.getSession();
        if(!examfile.isEmpty()){
            String path = "D:/files/exams/";
            String fileName = examfile.getOriginalFilename();
            File file = new File(path,fileName);
            if(!file.exists())file.createNewFile();
            examfile.transferTo(file);
            e.setFilepath(path+fileName);
            service.doUpdate(e);
        }
        map.addAttribute("o", e);
        return "examshow";
    }
    @RequestMapping(value="/fordoexam")
    String fordoExam(Courses course,Students stu,Chapters chapter,ModelMap map){
        Exams e = service.getExamByChapterId(chapter);
        ExamFile ef = fileservice.readxFile(e.getFilepath());
        ef.setExams(e);
        map.addAttribute("stu", stu);
        map.addAttribute("chapter", chapter);
        map.addAttribute("course", course);
        map.addAttribute("ef", ef);
        return "examonline";
    }
}
