package com.qdu.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qdu.teacher.bean.Exam;
import com.qdu.teacher.mapper.ExamMapper;


@Controller
@RequestMapping(value="/teacher")
public class TeacherController {
	@Autowired
	private ExamMapper examDao;
	
	@RequestMapping(value="/addexam")
	public boolean addExam(Exam exam){
		return	examDao.insert(exam) != 0 ? true : false;  
	}
	
	
}
