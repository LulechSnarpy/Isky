package com.lulech.dao.impl;

import com.lulech.pojo.Classes;
import com.lulech.pojo.Courses;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
@Repository
public class ClaDaoImpl extends HibernateBaseGenericDaoImpl<Classes, String>{

    public List<Classes> getClassCourse() {
        Session session = super.getSessionFactory().openSession();
        session.beginTransaction();
        String hql="select cla.classId,cou.courseId,cou.title,cla.className from Classes cla,Courses cou where cla.courses.courseId=cou.courseId";
        Query query=session.createQuery(hql);
        List list = query.list();
        List<Classes> olist = new LinkedList<>();
        for(Iterator it=list.iterator(); it.hasNext();){
            Object[] next=(Object[]) it.next();
            Classes cla = new Classes((String)next[0], (String)next[3]);
            cla.setCourses(new Courses((String)next[1], (String)next[2]));
            olist.add(cla);
        }
        session.getTransaction().commit();
        session.close();
        return olist;
    }    
}
