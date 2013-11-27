package com.easycms.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.easycms.common.Pager;

public interface Idao<T, PK extends Serializable> {
	/**
	 * 添加
	 * 
	 * @param entity
	 */
	public void save(T entity);

	/**
	 * 删除
	 * 
	 * @param entityClass
	 * @param pk
	 */
	public void delete(Class<T> entityClass, PK pk);
	/**
	 * 批量删除
	 * @param entityClass
	 */
    public void deleteIn(Class<T> entityClass, List<String> list);
	/**
	 * 更新
	 * 
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * 查询，按ID
	 * 
	 * @param entityClass
	 * @param pk
	 * @return
	 */
	public T findById(Class<T> entityClass, PK pk);
	
	/**
	 * 查询全部信息
	 * 
	 * @param entityClass
	 * @return
	 */
	public List<T> findAll(Class<T> entityClass);

	/**
	 * 分页
	 * 
	 * @param entityClass
	 * @param showPages
	 * @param pageSize
	 * @return
	 */
	public Pager<T> findByPage(Class<T> entityClass, int showPages, int pageSize);
	
	/**
	 * 带有一个条件的分页
	 * @param entityClass
	 * @param showPages
	 * @param pageSize
	 * @param key
	 * @return
	 */
	public Pager<T> findByPage(Class<T> entityClass, int showPages, int pageSize,Object key);

	/**
	 * 带多条件的分页
	 * @param entityClass
	 * @param maps
	 * @param operate
	 * @return
	 */
	public Pager<T> findByKey(Class<T> entityClass, Map<String, Object> maps,String operate);
	
	/**
	 * 判断某个值是否存在
	 * @param entityClass
	 * @param maps
	 * @param operate
	 * @return
	 */
	public int isExist(Class<T> entityClass,Map<String, Object> maps,String operate);
	
	/**
	 * 通过一个参数取到对应的对象
	 * 
	 * @param entityClass
	 * @param maps
	 * @param operate
	 * @return
	 */
	public T findByParam(Class<T> entityClass, Map<String, Object> maps, String operate);
	
	/**
	 * 排序
	 * @param entity
	 */
	public void updateOrder(T entity);
	/**
	 * 登录
	 * @param entity
	 * @return
	 */
	public T login(T entity);
}
