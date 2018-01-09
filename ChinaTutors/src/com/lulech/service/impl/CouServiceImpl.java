package com.lulech.service.impl;

import com.lulech.dao.impl.CouDaoImpl;
import com.lulech.pojo.Courses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouServiceImpl extends BaseGenericServiceImpl<Courses, String>{
    @Autowired
    CouDaoImpl dao;
    public List<Courses> getCourseByStuId(String stuId){
        return dao.getCourseByStuId(stuId);
    }
}
