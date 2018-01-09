package com.lulech.entity;

import com.lulech.pojo.Classes;
import java.io.Serializable;
import java.util.List;

public class ClassScore implements Serializable{
    private Classes classes;
    private List<OneScore> classscores;

    public ClassScore() {
    }

    public ClassScore(Classes classes, List<OneScore> classscores) {
        this.classes = classes;
        this.classscores = classscores;
    }
    
    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public List<OneScore> getClassscores() {
        return classscores;
    }

    public void setClassscores(List<OneScore> classscores) {
        this.classscores = classscores;
    }
    
}
