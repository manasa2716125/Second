package com.mccoy.service;


import com.mccoy.util.HibernateUtil;
	
	import com.mccoy.dao.BaseDao;
	import com.mccoy.dao.BaseDaoImpl;
	import com.mccoy.pojoclass.User;

	public class BaseServiceImpl implements BaseService {

	 private BaseDao loginDao = new BaseDaoImpl();

	 @Override
	 public boolean login(String username, String password) {
	  return loginDao.login(username, password);
	 }

	 @Override
	 public String registration(User user) {
	  return loginDao.register(user);
	 }

	}


