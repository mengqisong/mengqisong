package com.bw.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bw.service.ClassService;

@Controller
public class ClassController {
	@Resource
	private ClassService service;
	
	@RequestMapping("list.do")
	public String list(Model model){
		List<Class> list = service.list();
		model.addAttribute("list", list);
		return "list";
	}
}
