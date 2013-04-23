package com.easycms.base;

import java.io.Serializable;
import java.util.List;
import com.easycms.common.Pager;

public interface BaseDao<T,PK extends Serializable> {
	/**
	 * 添加
	 * @param entity
	 * @return
	 */
	public void save(T entity);
	/**
	 * 删除
	 * @param pk
	 */
	public void delete(PK pk);
	/**
	 * 更新
	 * @param entity
	 */
	public void update(T entity);
	/**
	 * 查询，按ID查询
	 * @param pk
	 */
	public T findById(PK pk);
	/**
	 * 查询全部信息
	 * @return
	 */
	public List<T> findAll();
	/**
	 * 
	 * @param showPages
	 * @param pageSize
	 * @return
	 */
	public Pager<T> findByPage(int showPages,int pageSize);
	
}
