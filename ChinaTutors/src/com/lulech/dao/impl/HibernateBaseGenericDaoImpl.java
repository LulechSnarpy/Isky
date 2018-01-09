package com.lulech.dao.impl;

import java.io.Serializable;
import java.util.List;
import com.lulech.dao.IBaseGenericDao;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateBaseGenericDaoImpl<T,P extends Serializable> implements IBaseGenericDao<T,P>{
    @Autowired
    private SessionFactory sessionFactory;
    private  Class<T> entityClass;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public HibernateBaseGenericDaoImpl() {
        this.entityClass = null;  
        Class c = getClass();  
        Type t = c.getGenericSuperclass();  
        if (t instanceof ParameterizedType) {  
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();  
            this.entityClass = (Class<T>) p[0];  
        }  
    }
    
    @Override
    public void doSave(T obj) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void doUpdate(T obj) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.update(obj);
        session.getTransaction().commit();
        session.close();
    }
    
    @Override
    public void doDelete(P id) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Object p=session.get(entityClass,id);
        session.delete(p);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public T getSelete(P id) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        T r=(T)session.get(entityClass,id);
        session.getTransaction().commit();
        session.close();
        return r;
    }

    @Override
    public List<T> getSeleteList() {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        String hql="from "+entityClass.getTypeName();
        Query query = session.createQuery(hql);
        List list=query.list();
        session.close();
        return list;
    }
}
