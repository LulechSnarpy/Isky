package com.lulech.dao.impl;

import com.lulech.pojo.Chapters;
import com.lulech.pojo.Courses;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class ChapDaoImpl extends HibernateBaseGenericDaoImpl<Chapters, String>{
    public List<Chapters> getChapterByCourse(Courses course){
        Chapters chapter=new Chapters();
        Session session = this.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Chapters where courses=:courses";
        Query query = session.createQuery(hql);
        query.setParameter("courses",course);
        List list = query.list();
//        System.out.println(list);
//        System.out.println(list.get(0));
//        System.out.println(((Chapters)list.get(0)).getChapterId());
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
