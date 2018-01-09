package com.lulech.dao.impl;

import com.lulech.pojo.Chapters;
import com.lulech.pojo.Exams;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class ExamsDaoImpl extends HibernateBaseGenericDaoImpl<Exams, String>{
    public Exams getExamByChapterId(Chapters chapter){
        Session session = super.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Exams e where e.chapters.chapterId=:chapterId";
        Query query = session.createQuery(hql);
        query.setParameter("chapterId",chapter.getChapterId());
        List list = query.list();
        session.getTransaction().commit();
        session.close();
        return (Exams) list.get(0);
    }
}
