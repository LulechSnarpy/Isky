package com.lulech.dao.impl;

import com.lulech.pojo.Courses;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class CouDaoImpl extends HibernateBaseGenericDaoImpl<Courses, String> {

    public List<Courses> getCourseByStuId(String stuId) {
        Session session = super.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "select cou from Courses cou,Classes cla,CurriculaVariable cv ";
        hql += "where cla.courses.courseId=cou.courseId and cv.classes.classId=cla.classId and cv.students.stuId=:stuId";
        Query query = session.createQuery(hql);
        query.setParameter("stuId", stuId);
        List list = query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
