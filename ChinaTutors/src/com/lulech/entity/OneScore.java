package com.lulech.entity;

import java.io.Serializable;

public class OneScore implements Serializable{
    private String stuId;
    private String cnName;
    private String enName;
    private String chapter;
    private Integer score;

    public OneScore() {
    }

    public OneScore(String stuId, String cnName, String enName, String chapter, Integer score) {
        this.stuId = stuId;
        this.cnName = cnName;
        this.enName = enName;
        this.chapter = chapter;
        this.score = score;
    }
    
    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
    
}
