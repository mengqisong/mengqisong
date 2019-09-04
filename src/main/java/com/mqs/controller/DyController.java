package com.mqs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mqs.entity.Dianying;
import com.mqs.entity.Type;
import com.mqs.service.DyService;

@Controller
public class DyController {
	@Resource
	private DyService service;
	
	@RequestMapping("Dylist.do")
	public String Dylist(Model model,String dname,@RequestParam(required=false,defaultValue="1")Integer pageNum){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dname", dname);
		
		PageHelper pageHelper = new PageHelper();
		
		pageHelper.startPage(pageNum, 1);
		
		List<Dianying> list = service.Dylist(map);
		
		PageInfo<Dianying> page = new PageInfo<Dianying>(list);
		
		model.addAttribute("page", page);
		
		return "Dy_list";
	}

	@RequestMapping("deleteAll.do")
	@ResponseBody
	public Boolean deleteAll(String did){
		Boolean flg = service.deleteAll(did);
		
		return flg;
	}
	
	@RequestMapping("listType.do")
	@ResponseBody
	public List<Type> listType(){
		List<Type> list = service.listType();
		
		return list;
	}
	
	@RequestMapping("addDy.do")
	@ResponseBody
	public Boolean addDy(Dianying dy){
		Map<String, Object> map = new HashMap<String, Object>();
		
		service.addDy(dy);
		
		String tid = dy.getTid();
		String[] split = tid.split(",");
		
		Integer did = dy.getDid();
		Boolean flg = false;
		for (int i = 0; i < split.length; i++) {
			map.put("tid", split[i]);
			map.put("did", did);
			
			 flg = service.addDtype(map);
		}
	
		return flg;
	}
	
	@RequestMapping("dianying.do")
	@ResponseBody
	public Dianying fingById(Integer did){
		
		Dianying d = service.fingById(did);
		
		return d;
	}
	
	@RequestMapping("updateDy.do")
	@ResponseBody
	public Boolean updateDy(Dianying dy){
		Map<String, Object> map = new HashMap<String, Object>();
		
		Boolean d = service.updateDy(dy);
		
		
		
		return d;
	}
}
