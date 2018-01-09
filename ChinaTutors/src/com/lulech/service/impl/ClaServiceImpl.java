package com.lulech.service.impl;

import com.lulech.dao.impl.ClaDaoImpl;
import com.lulech.pojo.Classes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClaServiceImpl extends BaseGenericServiceImpl<Classes, String>{
    @Autowired
    private ClaDaoImpl dao;
    public List<Classes> getClassCourse(){
        return dao.getClassCourse();
    }
}
