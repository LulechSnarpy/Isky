package com.lulech.controller;

import com.lulech.entity.ClassScore;
import com.lulech.entity.ExamFile;
import com.lulech.entity.OneTest;
import com.lulech.pojo.Chapters;
import com.lulech.pojo.Classes;
import com.lulech.pojo.Courses;
import com.lulech.pojo.Exams;
import com.lulech.pojo.Scores;
import com.lulech.pojo.Students;
import com.lulech.service.impl.ClaServiceImpl;
import com.lulech.service.impl.CouServiceImpl;
import com.lulech.service.impl.ExamsServiceImpl;
import com.lulech.service.impl.FileIOServiceImpl;
import com.lulech.service.impl.ScoresServiceImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ScoresController {

    @Autowired
    private ScoresServiceImpl service;
    @Autowired
    private ClaServiceImpl claservice;
    @Autowired
    private CouServiceImpl couservice;
    @Autowired
    private FileIOServiceImpl fileservice;
    @Autowired
    private ExamsServiceImpl examservice;
    
    @RequestMapping(value = "/stushowscore")
    String stuShowSore(Students stu, Courses course, Chapters chapter,ModelMap map) {
        map.addAttribute("stu", stu);
        map.addAttribute("scores", service.getScoresByChapterId(stu, chapter));
        map.addAttribute("course", course);
        return "stuScore";
    }

    @RequestMapping(value = "showclassscore")
    String teaShowScore(Classes cla, ModelMap map) {
        cla = claservice.getSelete(cla.getClassId());
        cla.setCourses(couservice.getSelete(cla.getCourses().getCourseId()));
        map.addAttribute("c", service.getScoresByClassId(cla));
        return "classscore";
    }
    
    @RequestMapping(value="download")
    public void download(Classes cla,HttpServletResponse response){
        cla = claservice.getSelete(cla.getClassId());
        cla.setCourses(couservice.getSelete(cla.getCourses().getCourseId()));
        ClassScore cs = service.getScoresByClassId(cla);
        try {
            response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\"", "classscore.xls"));
            fileservice.download(cs,response.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ScoresController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @RequestMapping(value="/checkAnswer")
    String submitResult(Courses course,Students stu,Chapters chapter,ModelMap map,HttpServletRequest req){
        System.out.println(chapter.getChapterId());
        Exams e = examservice.getExamByChapterId(chapter);
        ExamFile ef = fileservice.readxFile(e.getFilepath());
        List<OneTest> otlist = ef.getTestslist();
        int result = 0;
        List<OneTest> wrong = new ArrayList<>();
        for(int i=0; i<otlist.size(); i++){
            OneTest ot = otlist.get(i);
            String ch = req.getParameter("q"+ot.getId());
            if(ch!=null&&ch.equals(ot.getKeyanswer())){
                result++;
            }else{
                ot.setAnswer(ch);
                wrong.add(ot);
            }
        }
        result = result*100/otlist.size();
        service.doSave(new Scores("SCR000000"+(service.getSeleteList().size()+1), e, stu, result));
        map.addAttribute("stu", stu);
        map.addAttribute("result",result);
        map.addAttribute("wrong", wrong);
        map.addAttribute("course", course);
        map.addAttribute("e", e);
        return "examresult";
    }
}
