package com.lulech.pojo;
// Generated 2017-6-16 0:05:20 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Classes generated by hbm2java
 */
public class Classes  implements java.io.Serializable {


     private String classId;
     private Courses courses;
     private Teachers teachers;
     private String className;
     private Set curriculaVariables = new HashSet(0);

    public Classes() {
    }

	
    public Classes(String classId, String className) {
        this.classId = classId;
        this.className = className;
    }
    public Classes(String classId, Courses courses, Teachers teachers, String className, Set curriculaVariables) {
       this.classId = classId;
       this.courses = courses;
       this.teachers = teachers;
       this.className = className;
       this.curriculaVariables = curriculaVariables;
    }
   
    public String getClassId() {
        return this.classId;
    }
    
    public void setClassId(String classId) {
        this.classId = classId;
    }
    public Courses getCourses() {
        return this.courses;
    }
    
    public void setCourses(Courses courses) {
        this.courses = courses;
    }
    public Teachers getTeachers() {
        return this.teachers;
    }
    
    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
    }
    public String getClassName() {
        return this.className;
    }
    
    public void setClassName(String className) {
        this.className = className;
    }
    public Set getCurriculaVariables() {
        return this.curriculaVariables;
    }
    
    public void setCurriculaVariables(Set curriculaVariables) {
        this.curriculaVariables = curriculaVariables;
    }




}

