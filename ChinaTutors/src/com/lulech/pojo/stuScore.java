package com.lulech.pojo;

import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class stuScore implements Serializable{
    private String chapterTitle;
    private String ECode;
    private Integer score;

    public stuScore() {
    }

    public stuScore(String chapterTitle, String ECode, Integer score) {
        this.chapterTitle = chapterTitle;
        this.ECode = ECode;
        this.score = score;
    }
    
    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }
    

    public String getECode() {
        return ECode;
    }

    public void setECode(String ECode) {
        this.ECode = ECode;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
    
}
