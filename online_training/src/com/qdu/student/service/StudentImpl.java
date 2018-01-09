package com.qdu.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qdu.student.bean.Student;
import com.qdu.student.bean.StudentExample;
import com.qdu.student.mapper.StudentMapper;

@Service
public class StudentImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;

	@Override
	public int add(Student student) {
		return studentMapper.insert(student);
	}

	@Override
	public boolean checkStudent(String username, String password) {
		StudentExample example = new StudentExample();
		example.createCriteria().andSnameEqualTo(username)
				.andSpasswordEqualTo(password);
		return null!=studentMapper.selectByExample(example);
	}
	
}
