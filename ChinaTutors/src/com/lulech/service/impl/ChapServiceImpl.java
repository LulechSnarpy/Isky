package com.lulech.service.impl;

import com.lulech.dao.impl.ChapDaoImpl;
import com.lulech.pojo.Chapters;
import com.lulech.pojo.Courses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChapServiceImpl extends BaseGenericServiceImpl<Chapters, String>{
    @Autowired
    private ChapDaoImpl dao;
    public List<Chapters> getChapterByCourse(Courses course){
        return dao.getChapterByCourse(course);
    }
}
