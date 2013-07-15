package com.easycms.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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
	 * 批量删除
	 * @param pks
	 */
	
	public void deleteIn(List<String> list);
	 
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
	
	/**
	  * 通过一个参数取到对应的对象
	  * @param maps
	  * @param operate
	  * @return
	  */
	public T findByParam(Map<String, Object> maps,String operate);
	
	/**
	 * 排序
	 * @param entity
	 */
	public void updateOrder(T entity);

}
