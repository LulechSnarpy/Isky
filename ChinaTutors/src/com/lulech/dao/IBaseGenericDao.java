package com.lulech.dao;

import java.io.Serializable;
import java.util.List;

public abstract interface IBaseGenericDao<T,P extends Serializable>{
    public abstract void doSave(T obj);
    public abstract void doUpdate(T obj);
    public abstract void doDelete(P id);
    public abstract T getSelete(P id);
    public abstract List<T> getSeleteList();
}
