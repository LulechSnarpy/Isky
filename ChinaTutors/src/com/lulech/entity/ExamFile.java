package com.lulech.entity;

import com.lulech.pojo.Exams;
import java.io.Serializable;
import java.util.List;

public class ExamFile implements Serializable{
    private Exams exams;
    private List<OneTest> testslist;
   
    public Exams getExams() {
        return exams;
    }

    public void setExams(Exams exams) {
        this.exams = exams;
    }

    public List<OneTest> getTestslist() {
        return testslist;
    }

    public void setTestslist(List<OneTest> testslist) {
        this.testslist = testslist;
    }
    
}
