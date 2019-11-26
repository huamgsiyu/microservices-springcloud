package com.syh.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syh.springcloud.dao.DeptDao;
import com.syh.springcloud.entities.Dept;
import com.syh.springcloud.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao deptDao;
	
	@Override
	public boolean add(Dept dept) {
		return deptDao.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		return deptDao.findById(id);
	}

	@Override
	public List<Dept> list() {
		return deptDao.findAll();
	}

}
