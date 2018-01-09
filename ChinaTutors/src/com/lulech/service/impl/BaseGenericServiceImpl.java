package com.lulech.service.impl;

import com.lulech.dao.impl.HibernateBaseGenericDaoImpl;
import com.lulech.service.IBaseGenericService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseGenericServiceImpl<T,P extends Serializable> implements IBaseGenericService<T,P>{
    @Autowired
    private HibernateBaseGenericDaoImpl<T,P> dao;
    
    @Override
    public void doSave(T obj) {
        dao.doSave(obj);
    }

    @Override
    public void doUpdate(T obj) {
        dao.doUpdate(obj);
    }
    
    @Override
    public void doDelete(P id) {
        dao.doDelete(id);
    }

    @Override
    public T getSelete(P id) {
       return (T) dao.getSelete(id);
    }

    @Override
    public List<T> getSeleteList() {
        return dao.getSeleteList();
    }
}
