package com.easycms.base;

import java.io.Serializable;

public interface BaseDao<T,PK extends Serializable> {
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public void save(T entity);
	
}
