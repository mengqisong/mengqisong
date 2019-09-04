package com.mqs.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mqs.entity.Dianying;
import com.mqs.entity.Type;
import com.mqs.mapper.DyDao;

@Service
public class DyServiceImpl implements DyService{
	@Resource
	private DyDao dao;
	
	public List<Dianying> Dylist(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.Dylist(map);
	}

	public Boolean deleteAll(String did) {
		// TODO Auto-generated method stub
		return dao.deleteAll(did);
	}

	public List<Type> listType() {
		// TODO Auto-generated method stub
		return dao.listType();
	}

	public void addDy(Dianying dy) {
		// TODO Auto-generated method stub
		dao.addDy(dy);
	}

	public Boolean addDtype(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.addDtype(map);
	}

	public Dianying fingById(Integer did) {
		// TODO Auto-generated method stub
		return dao.fingById(did);
	}

	public Boolean updateDy(Dianying dy) {
		// TODO Auto-generated method stub
		return dao.updateDy(dy);
	}

}
