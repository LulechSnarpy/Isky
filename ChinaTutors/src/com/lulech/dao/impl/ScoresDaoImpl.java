package com.lulech.dao.impl;

import com.lulech.entity.OneScore;
import com.lulech.pojo.Chapters;
import com.lulech.pojo.Classes;
import com.lulech.pojo.Scores;
import com.lulech.pojo.Students;
import com.lulech.pojo.stuScore;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class ScoresDaoImpl extends HibernateBaseGenericDaoImpl<Scores, String>{
    
    public List<stuScore> getScoresByChapterId(Students student,Chapters chapter){
        Session session = super.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "select c.title, e.ECode, s.score from  Scores s, Exams e, Chapters c where e.ECode=s.exams.ECode and e.chapters.chapterId=c.chapterId and e.chapters.chapterId=:chapters and s.students.stuId=:students";
        Query query = session.createQuery(hql);
        query.setParameter("chapters", chapter.getChapterId());
        query.setParameter("students", student.getStuId());
        List list = query.list();
        List<stuScore> slist = new LinkedList<>();
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Object[] next = (Object[]) iterator.next();
            stuScore ss = new stuScore((String) next[0],(String) next[1],(Integer) next[2]);
            slist.add(ss);
        }
        session.getTransaction().commit();
        session.close();
        return slist;
    }
    
     public List<OneScore> getScoresByClassId(Classes classes){
        Session session = super.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "select stu.stuId,stu.cnName,stu.enName,chap.chapter,s.score from Students stu,CurriculaVariable cv,Classes cla,Chapters chap,Exams e,Scores s ";
        hql+="where stu.stuId=cv.students.stuId and cv.classes.classId =cla.classId and cla.courses.courseId = chap.courses.courseId and e.chapters.chapterId=chap.chapterId ";
        hql+="and e.ECode=s.exams.ECode and s.students.stuId=stu.stuId and cla.classId=:classId";
        Query query = session.createQuery(hql);
        query.setParameter("classId", classes.getClassId());
        List list = query.list();
        List<OneScore> olist = new LinkedList<>();
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Object[] next = (Object[]) iterator.next();
            OneScore os = new OneScore((String) next[0],(String) next[1], (String) next[2],(String) next[3],(Integer) next[4]);
            olist.add(os);
        }
        session.getTransaction().commit();
        session.close();
        return olist;
    }
}
