package com.easycms.dao;

import java.io.Serializable;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

@Service
public class IdaoImpl<T,PK extends Serializable> extends SqlSessionDaoSupport implements Idao<T, Serializable>{
	@Override
	public void save(T entity) {
		getSqlSession().insert(entity.getClass().getName()+".add", entity);
	}
	
	@Override
	public void delete(Class<T> entityClass, Serializable pk) {
		getSqlSession().delete(entityClass.getName()+".delete", pk);
	}

	@Override
	public void update(T entity) {
		getSqlSession().update(entity.getClass().getName(),entity);
	}

	@Override
	public T findById(Class<T> entityClass, Serializable pk) {
		return getSqlSession().selectOne(entityClass.getName()+".findById", pk);
	}

	@Override
	public List<T> findAll(Class<T> entityClass) {
		return getSqlSession().selectList(entityClass.getName()+".findAll");
	}

}
