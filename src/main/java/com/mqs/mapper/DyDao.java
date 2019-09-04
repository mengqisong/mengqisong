package com.mqs.mapper;

import java.util.List;
import java.util.Map;

import com.mqs.entity.Dianying;
import com.mqs.entity.Type;

public interface DyDao {

	public List<Dianying> Dylist(Map<String, Object> map);

	public Boolean deleteAll(String did);

	public List<Type> listType();

	public void addDy(Dianying dy);

	public Boolean addDtype(Map<String, Object> map);

	public Dianying fingById(Integer did);

	public Boolean updateDy(Dianying dy);

}
