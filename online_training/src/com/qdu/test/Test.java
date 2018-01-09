package com.qdu.test;

import java.util.Date;

import com.qdu.teacher.bean.Exam;
import com.qdu.teacher.controller.TeacherController;



public class Test {
	
	public static void main(String[] args) {
		
	
		TeacherController t = new TeacherController();
		Exam exam = new Exam();
		exam.setEname("ÉúÎï");
		exam.setTime(60);
		t.addExam(exam);
	}
}
