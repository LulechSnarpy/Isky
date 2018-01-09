package com.lulech.service.impl;

import com.lulech.dao.impl.ExamsDaoImpl;
import com.lulech.pojo.Chapters;
import com.lulech.pojo.Exams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamsServiceImpl extends BaseGenericServiceImpl<Exams, String>{
    @Autowired
    private ExamsDaoImpl dao;
    public Exams getExamByChapterId(Chapters chapter){
        return dao.getExamByChapterId(chapter);
    }
}
