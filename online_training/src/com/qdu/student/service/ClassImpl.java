package com.qdu.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qdu.student.mapper.ClassMapper;

public class ClassImpl implements ClassService {

	@Autowired
	private ClassMapper classMapper;
	
	@Override
	public List<Class> queryAllClass() {
		return classMapper.selectByExample(null);
	}

	@Override
	public int addClass(Class cls) {
		return classMapper.insert(cls);
	}
	
	
}
