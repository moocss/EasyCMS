package com.easycms.dao;
import java.io.Serializable;

public interface Idao<T,PK extends Serializable>{
	public void save(T entity);
}
