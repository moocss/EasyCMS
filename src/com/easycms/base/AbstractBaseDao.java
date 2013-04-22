package com.easycms.base;
import java.io.Serializable;

import javax.annotation.Resource;
import com.easycms.dao.Idao;

public abstract class AbstractBaseDao<T,PK extends Serializable> implements BaseDao<T,PK>{
	
	@Resource
	private Idao<T, Serializable> idao;
	@Override
	public void save(T entity) {
		idao.save(entity);
	}

}
