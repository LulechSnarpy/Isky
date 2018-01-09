package com.lulech.service.impl;

import com.lulech.dao.impl.ScoresDaoImpl;
import com.lulech.entity.ClassScore;
import com.lulech.pojo.Chapters;
import com.lulech.pojo.Classes;
import com.lulech.pojo.Scores;
import com.lulech.pojo.Students;
import com.lulech.pojo.stuScore;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoresServiceImpl extends BaseGenericServiceImpl<Scores, String>{
    @Autowired
    private ScoresDaoImpl scoredao;
    public List<stuScore> getScoresByChapterId(Students stu,Chapters chapter){
      return scoredao.getScoresByChapterId(stu, chapter);
    }
    
    public ClassScore getScoresByClassId(Classes classes){
        ClassScore cs = new ClassScore();
        cs.setClasses(classes);
        cs.setClassscores(scoredao.getScoresByClassId(classes));
        return cs;
    }
}
