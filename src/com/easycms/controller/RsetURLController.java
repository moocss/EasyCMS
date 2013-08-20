package com.easycms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value="rsetURLController")
@RequestMapping(value="userinfo")
public class RsetURLController {
	/* 
		/userinfo              GET  => index()  
		/userinfo/new          GET  => _new()  
		/userinfo/{id}         GET  => _show()  
		/userinfo/{id}/edit    GET  => _edit()  
		/userinfo              POST => _create()  
		/userinfo/{id}         PUT  => _update() 
		/userinfo/{id}         DELETE => _delete()  
		/userinfo              DELETE => _batchDelete() 
	*/
	private final String LIST_ACTION = "redirect:/userinfo";
	/**
	 * 进入默认列表
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap map){
		map.addAttribute("rest", "GET");
		map.addAttribute("val", "进入默认列表");
		return "userinfo";
	}
	/**
	 * 进入默认新增
	 * @return
	 */
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String _new(ModelMap map){
		map.addAttribute("rest", "GET");
		map.addAttribute("val", "进入默认新增");
		return "userinfo";
	}
	/**
	 * 进入显示
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String _show(@PathVariable(value="id")String id,ModelMap map){
		map.addAttribute("rest", "GET");
		map.addAttribute("val", "进入显示");
		return "userinfo";
	}
	/**
	 * 进入保存新增
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String _create(ModelMap map){
		map.addAttribute("rest", "POST");
		map.addAttribute("val", "进入保存新增");
		return "userinfo";
	}
	/**
	 * 进入编辑
	 * @return
	 */
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String _edit(ModelMap map){
		map.addAttribute("rest", "GET");
		map.addAttribute("val", "进入编辑");
		return LIST_ACTION;
	}
	/**
	 * 进入保存更新
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String _update(ModelMap map){
		map.addAttribute("rest", "PUT");
		map.addAttribute("val", "进入保存更新");
		return LIST_ACTION;
	}
	/**
	 * 进入删除
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String _delete(ModelMap map){
		map.addAttribute("rest", "PUT");
		map.addAttribute("val", "进入删除");
		return LIST_ACTION;
	}
	
	/**
	 * 进入批量删除
	 * @return
	 */
	@RequestMapping(method=RequestMethod.DELETE)
	public String _batchDelete(ModelMap map){
		map.addAttribute("rest", "PUT");
		map.addAttribute("val", "进入批量删除");
		return LIST_ACTION;
	}

}
