package com.qdu.student.service;

import com.qdu.student.bean.Student;

public interface StudentService {
	// 添加学生
	public int add(Student student);

	// 登入
	public boolean checkStudent(String username, String password);

}
