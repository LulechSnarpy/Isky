package com.qdu.student.service;

import com.qdu.student.bean.Student;

public interface StudentService {
	// ���ѧ��
	public int add(Student student);

	// ����
	public boolean checkStudent(String username, String password);

}
