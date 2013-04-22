package com.easycms.dao;

import java.io.Serializable;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

@Service
public class IdaoImpl<T,PK extends Serializable> extends SqlSessionDaoSupport implements Idao<T, Serializable>{

	@Override
	public void save(T entity) {
		getSqlSession().insert(entity.getClass().getName()+".add", entity);
	}

}
