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
	 * 分页
	 * @param showPages
	 * @param pageSize
	 * @return
	 */
	public Pager<T> findByPage(int showPages,int pageSize);
	
	/**
	 * 带有一个条件的分页
	 * @param entityClass
	 * @param showPages
	 * @param pageSize
	 * @param key
	 * @return
	 */
	public Pager<T> findByPage(int showPages, int pageSize,Object key);
	
	/**
	 * 多条件的分页查询
	 * @param maps
	 * @param operate
	 * @return
	 */
    public Pager<T> findByKey(Map<String, Object> maps,String operate);
    
	/**
	 * 判断某个值是否存在
	 * @param entityClass
	 * @param maps
	 * @param operate
	 * @return
	 */
	public int isExist(Map<String, Object> maps,String operate);
	
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
	/**
	 * 登录
	 * @param entity
	 * @return
	 */
	public T login(T entity);
}
